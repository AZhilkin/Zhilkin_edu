package edu_task_3;

/**
 * Created by Alexandr Zhilkin on 10.12.2016.
 */

import com.education.task3.TheBiggestIntervalSearchable;
import java.util.List;

public class edu_task_3 implements TheBiggestIntervalSearchable{
    @Override
    public int[] getTheBiggestInterval(List list) {
        int N = list.size();
        int[] listInt = toIntArray(list);
        int[] starts = new int[N];
        int[] ends = new int[N];
        starts[0] = listInt[0];
        ends[0] = listInt[0];
        int iter = 1;
        for(int i = 1; i < N; i++){
            boolean flag = false;
            for(int j = 0; j < iter; j++){
                if(starts[j] == listInt[i]+1){
                    starts[j]--;
                    flag = true;
                }
                if(ends[j] == listInt[i]-1){
                    ends[j]++;
                    flag = true;
                }
            }
            if(!flag){
                starts[iter] = listInt[i];
                ends[iter] = listInt[i];
                iter++;
            }
        }
        int start = 0;
        int end = 0;
        for(int i = 0; i < iter; i++){
            int tmpStart = starts[i];
            int tmpEnd = ends[i];
            for(int j = 0; j < iter; j++){
                if(tmpStart < ends[j] && tmpEnd > ends[j] && tmpStart > starts[j]){
                    tmpStart = starts[j];
                }
                if(tmpStart < starts[j] && tmpEnd > starts[j] && tmpEnd < ends[j]){
                    tmpEnd = ends[j];
                }
            }
            if(tmpEnd-tmpStart > end-start){
                start = tmpStart;
                end = tmpEnd;
            }
        }
        return createArray(start, end);
    }

    private int[] createArray(int start, int end){
        int[] tmp = new int[end-start];
        int iter = 0;
        for(int i = start; i <= end; i++){
            tmp[iter] = i;
            iter++;
        }
        return tmp;
    }

    private int[] toIntArray(List<Integer> list){
        int[] ret = new int[list.size()];
        for(int i = 0;i < ret.length;i++)
            ret[i] = list.get(i);
        return ret;
    }
}
