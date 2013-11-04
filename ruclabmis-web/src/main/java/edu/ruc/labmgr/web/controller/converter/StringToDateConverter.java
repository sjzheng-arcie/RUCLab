package edu.ruc.labmgr.web.controller.converter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lcheng
 * @version 1.0
 *          ${tags}
 */
public class StringToDateConverter implements Converter<String,Date>{

    @Override
    public Date convert(String s) {
        if(!StringUtils.isEmpty(s)){
            assert (s.length()==10|| s.length()==19):"日期格式长度错误!";
            String format = (s.length()==10) ? "yyyy-MM-dd" : "yyyy-MM-dd HH:mm:ss";
            DateFormat df = new SimpleDateFormat(format);
            try{
                return df.parse(s);
            }catch (ParseException e){
                throw new IllegalArgumentException(String.format("类型转换失败，需要格式%s，但格式是[%s]", format, s));
            }
        }
        return new Date();
    }
}
