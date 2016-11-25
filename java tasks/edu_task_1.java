/**
 * Created by Alexandr Zhilkin on 24.11.2016.
 */

import com.education.task1_2.CommonPartFinder;

public class edu_task_1 implements CommonPartFinder{

    @Override
    public String getMaxLengthCommonPart(String[] strings) {
        return null;
    }

    @Override
    public String getMaxLengthCommonPrefix(String[] strings) {
        int N = strings.length;
        String Common = "";
        boolean Flag = true;
        for (int i = 0; (i < strings[0].length())&&Flag; i++){
            for(int j = 1; (i < N)&&Flag; j++){
                if(strings[0].charAt(i) != strings[j].charAt(i)){
                    Flag = false;
                    Common = strings[0].substring(0, i);
                }
            }
        }
        return Common;
    }
}
