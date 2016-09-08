package jp.co.hello.batch.utils;

/**
 * Hello Batch Framework - Utility
 *
 * @author palsysuser
 */
public class HelloBatchUtils {

    /**
     * サニタイズ処理
     *
     * @param s 変換元文字列
     * @return 変換結果文字列
     */
    public static String getSanitizedString(String s){
    	if (s == null) {
    		return "";
    	}

        String str = s;

        str = str.replace("<","&lt;");
        str = str.replace(">","&gt;");
        str = str.replace("\"","&quot;");
        str = str.replace(" ","&ensp;");

        str = str.replace("\t","&ensp;&ensp;&ensp;&ensp;");
        str = str.replace("\n","<br>");

        return str;
    }

}
