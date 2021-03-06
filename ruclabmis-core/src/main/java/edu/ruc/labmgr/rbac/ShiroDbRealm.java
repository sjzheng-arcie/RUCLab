package edu.ruc.labmgr.rbac;

import edu.ruc.labmgr.domain.Privilege;
import edu.ruc.labmgr.domain.Role;
import edu.ruc.labmgr.domain.User;
import edu.ruc.labmgr.mapper.RoleMapper;
import edu.ruc.labmgr.mapper.UserMapper;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

@SuppressWarnings("ALL")
public class ShiroDbRealm extends AuthorizingRealm {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    /**
     * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principals) {
        String name = principals.getRealmNames().iterator().next();
        String userSn = (String) principals.fromRealm(name).iterator().next();

        if (userSn != null) {
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            User user = userMapper.selectUserByLoginSn(userSn);
            if (user != null && user.getRole() != null) {
                Role role = user.getRole();
                if (role != null && role.getPrivileges() != null) {
                    info.addRole(role.getName());

                    for (Privilege eachPrivilege : role.getPrivileges()) {
                        info.addStringPermission(eachPrivilege.getName());
                    }
                }
            }
            return info;
        }

        return null;
    }

    /**
     * 登录时调用
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authcToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        token.setRememberMe(true);
        User user = userMapper.selectUserByLoginSn(token.getUsername());

        if (user != null) {
            return new SimpleAuthenticationInfo(user.getSn(), user
                    .getPassword(), user.getName());
        }
        return null;
    }
}