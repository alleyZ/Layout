package com.alleyz.data.share;

import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.SwitchPreference;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.alleyz.layout.R;

/**
 * Created by Mr on 2015/12/24.
 */
public class MineSharePreferenceActivity extends PreferenceActivity implements Preference.OnPreferenceChangeListener{
    PreferenceManager pm;
    ListPreference lp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.share_pre_mine);
        pm=getPreferenceManager();
        lp = (ListPreference) findPreference("LP");
        lp.setOnPreferenceChangeListener(this);
        findPreference("CBP").setOnPreferenceChangeListener(this);
        findPreference("ETP").setOnPreferenceChangeListener(this);
        findPreference("SP").setOnPreferenceChangeListener(this);
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        switch (preference.getKey()){
            case "LP":
                Toast.makeText(this,"你的选择："+newValue,Toast.LENGTH_SHORT).show();
                break;
            case "CBP":
                String str=(boolean)newValue? ((CheckBoxPreference) preference).getSummaryOn().toString():((CheckBoxPreference) preference).getSummaryOff().toString();
                preference.setSummary(str);
                Toast.makeText(this,"当前选择"+str,Toast.LENGTH_SHORT).show();
                break;
            case "ETP":
                Toast.makeText(this,"你的输入："+newValue,Toast.LENGTH_SHORT).show();
                break;
            case "SP":
                String str1=(boolean)newValue? ((SwitchPreference) preference).getSwitchTextOn().toString():((SwitchPreference) preference).getSwitchTextOff().toString();
                preference.setSummary(str1);
                Toast.makeText(this,"你的选择："+str1,Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
