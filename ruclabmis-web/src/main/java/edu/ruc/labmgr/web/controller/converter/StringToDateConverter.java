package edu.ruc.labmgr.web.controller.converter;

import com.mysql.jdbc.StringUtils;
import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDateConverter implements Converter<String,Date>{

    @Override
    public Date convert(String strDate) {
        if(!StringUtils.isNullOrEmpty(strDate)){
            try{
                if(strDate.length() <= 8){
                    DateFormat df = new SimpleDateFormat("HH:mm:ss");
                    return df.parse(strDate);
                } else if( strDate.length() <= 10){
                    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                    return df.parse(strDate);
                }
                else{
                    DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    return df.parse(strDate);
                }

            }catch (ParseException e){
                throw new IllegalArgumentException(String.format("日期时间到字符串类型转换失败-[%s]", strDate));
            }

        }
        return null;
    }
}
