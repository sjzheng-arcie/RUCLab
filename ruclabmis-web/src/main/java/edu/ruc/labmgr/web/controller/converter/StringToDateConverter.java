package edu.ruc.labmgr.web.controller.converter;

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
    private String format;

    public StringToDateConverter(String format){
         this.format = format;
    }
    @Override
    public Date convert(String s) {
        if(s!=null){
            DateFormat df = new SimpleDateFormat(format);
            try{
                return df.parse(s);
            }catch (ParseException e){
                throw new IllegalArgumentException(String.format("类型转换失败，需要格式%s，但格式是[%s]", format, s));
            }

        }
        return null;
    }
}
