/**
 * Created by Alexandr Zhilkin on 24.11.2016.
 */

import com.education.task1_2.CommonPartFinder;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class edu_task_2 implements CommonPartFinder{

    @Override
    public String getMaxLengthCommonPart(String[] strings) {
		int N = strings.length;
		if (N == 0) {
			return null;
		}
        int StartPos = 0;
        int EndPos = strings[0].length();
        int CurrLength = EndPos-StartPos;
        while (CurrLength > 0){
            Pattern p = Pattern.compile(strings[0].substring(StartPos, EndPos));
            Matcher m;
            boolean InnerFlag = true;
            for (int i = 1; (i < N)&&InnerFlag; i++){
                m = p.matcher(strings[i]);
                InnerFlag = m.matches();
            }
            if (InnerFlag){
                break;
            } else {
                if (CurrLength == 1){
                    return "";
                }
                if (EndPos == strings[0].length()){
                    StartPos = 0;
                    CurrLength--;
                    EndPos = CurrLength;
                } else {
                    StartPos++;
                    EndPos++;
                }
            }
        }
        return strings[0].substring(StartPos, EndPos);
    }

    @Override
    public String getMaxLengthCommonPrefix(String[] strings) {
        int N = strings.length;
		if (N == 0) {
			return null;
		}
        String Common = "";
        boolean Flag = true;
        for (int i = 0; (i < strings[0].length())&&Flag; i++){
            for(int j = 1; (j < N)&&Flag; j++){
                if(strings[0].charAt(i) != strings[j].charAt(i)){
                    Flag = false;
                    Common = strings[0].substring(0, i);
                }
            }
        }
        return Common;
    }
}
