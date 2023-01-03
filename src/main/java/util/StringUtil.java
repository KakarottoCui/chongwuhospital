package util;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 字符串处理工具
 */
public class StringUtil {

    /**
     * 将数组或列表，转换成：a,b,c,d 这样的字符串“,”根据des 变换
     * @param des
     * @param list
     * @return
     */
    public static String join(String des , Object list){
        StringBuffer buffer = new StringBuffer();

        if(list instanceof int[]) {
            int[] var = (int[]) list;
            for(int i=0;i<var.length;i++){
                if(i>0){
                    buffer.append(des);
                }
                buffer.append(var[i]);
            }
        }else if(list instanceof long[]) {
            long[] var = (long[]) list;
            for(int i=0;i<var.length;i++){
                if(i>0){
                    buffer.append(des);
                }
                buffer.append(var[i]);
            }
        }else if(list instanceof double[]) {
            double[] var = (double[]) list;
            for(int i=0;i<var.length;i++){
                if(i>0){
                    buffer.append(des);
                }
                buffer.append(var[i]);
            }
        }else if(list instanceof float[]) {
            float[] var = (float[]) list;
            for(int i=0;i<var.length;i++){
                if(i>0){
                    buffer.append(des);
                }
                buffer.append(var[i]);
            }
        }else if(list instanceof String[]) {
            String[] var = (String[]) list;
            for(int i=0;i<var.length;i++){
                if(i>0){
                    buffer.append(des);
                }
                buffer.append(var[i]);
            }
        }else if(list instanceof boolean[]) {
            boolean[] var = (boolean[]) list;
            for(int i=0;i<var.length;i++){
                if(i>0){
                    buffer.append(des);
                }
                buffer.append(var[i]?"true" : "false");
            }
        }else if(list instanceof List){
            List var = (List) list;
            for(int i=0;i<var.size();i++){
                if(i>0){
                    buffer.append(des);
                }
                buffer.append(var.get(i));
            }
        }else if(list instanceof Map){
            Map var = (Map) list;
            Iterator entries = var.entrySet().iterator();
            int i=0;
            while (entries.hasNext()) {
                if(i>0){
                    buffer.append(des);
                }
                Map.Entry entry = (Map.Entry) entries.next();
                Object value = entry.getValue();
                buffer.append(value);
                i++;
            }
        }else if(list instanceof Iterable)
        {
            Iterator it = ((Iterable)list).iterator();
            int i=0;
            while(it.hasNext()){
                if(i > 0) buffer.append(des);
                Object str = it.next();
                buffer.append(str);
                i++;
            }
        }

        return buffer.toString();
    }
}
