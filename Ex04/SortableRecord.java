import java.util.Arrays;
import java.lang.*;
import java.util.*;

public class SortableRecord extends Record implements Comparable<SortableRecord>{
    public SortableRecord(String id, int m, int j, int e){
        super(id,m,j,e);
    }

    public Integer getTotal(){
        return score_total;
    }
    public Integer getMath(){
        return score_math;
    }
    public Integer getJapanese(){
        return score_Japanese;
    }
    public Integer getEnglish(){
        return score_English;
    }

    public int compareTo(SortableRecord  v){
        int result;
        result = v.getTotal().compareTo(this.getTotal());
        if(result == 0){
            result =v.getMath().compareTo(this.getMath());
            if(result == 0){
                result = v.getJapanese().compareTo(this.getJapanese());
                if(result == 0){
                    result = v.getEnglish().compareTo(this.getEnglish());
                }
            }
        }
        return result;
    }
}
