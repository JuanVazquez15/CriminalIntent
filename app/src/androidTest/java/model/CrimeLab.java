package model;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CrimeLab {
    private static CrimeLab mCrimeLab;
    private List<Crime> mCrime;

    public static CrimeLab get(Context context){
        if (mCrimeLab == null){
            mCrimeLab = new CrimeLab(context);
        }
        return mCrimeLab;
    }
    private CrimeLab(Context context){
        mCrime = new ArrayList<>();
        for (int i =1; i<=100; i++){
            Crime crime = new Crime();
            crime.setTitle("Crime #" + i);
            crime.setSolved(i % 2 == 0);
            mCrime.add(crime);
        }
    }
    public List<Crime> getCrimes(){
        return mCrime;
    }
    public Crime getCrime(UUID crimeId){
        for (Crime crime: mCrime){
            if(crime.getId().equals(crimeId)){
                return crime;
            }
        }
        return null;
    }
}
