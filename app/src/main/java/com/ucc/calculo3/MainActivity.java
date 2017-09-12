package com.ucc.calculo3;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class MainActivity extends Activity {
    private EditText et1,et2;
    private TextView tv;
    private CheckBox cb1,cb2,cb3,cb4,cb5;
    private Toast t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=(EditText)findViewById(R.id.editText1);
        et2=(EditText)findViewById(R.id.editText2);
        tv=(TextView)findViewById(R.id.textView1);
        cb1=(CheckBox)findViewById(R.id.checkBox1);
        cb2=(CheckBox)findViewById(R.id.checkBox2);
        cb3=(CheckBox)findViewById(R.id.checkBox3);
        cb4=(CheckBox)findViewById(R.id.checkBox4);
        cb5=(CheckBox)findViewById(R.id.checkBox5);
        t=Toast.makeText(this,"",Toast.LENGTH_LONG);
        proceso();


    }
    public void proceso()
    {
        final DecimalFormat df = new DecimalFormat("#.#");
        df.setRoundingMode(RoundingMode.CEILING);

        cb1.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
            if(arg1)
            { try
            { double a=Double.parseDouble(et1.getText().toString());
                double b=Double.parseDouble(et2.getText().toString());
                tv.setText("Total: "+ df.format((a+b)));
            }
            catch(NumberFormatException e)
            { t.setText("Falta dato");  t.show(); }
                cb2.setChecked(false); cb3.setChecked(false); cb4.setChecked(false); cb5.setChecked(false);
            }
        }
    });
        cb2.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
                if(arg1)
                { try
                { double a=Double.parseDouble(et1.getText().toString());
                    double b=Double.parseDouble(et2.getText().toString());
                    tv.setText("Total: "+ df.format(a-b));
                }
                catch(NumberFormatException e)
                { t.setText("Falta dato");  t.show(); }
                    cb1.setChecked(false); cb3.setChecked(false); cb4.setChecked(false); cb5.setChecked(false);
                }
            }
        });
        cb3.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
                if(arg1)
                { try
                { double a=Double.parseDouble(et1.getText().toString());
                    double b=Double.parseDouble(et2.getText().toString());
                    tv.setText("Total: "+df.format(a*b));
                }
                catch(NumberFormatException e)
                { t.setText("Falta dato");  t.show(); }
                    cb1.setChecked(false); cb2.setChecked(false); cb4.setChecked(false); cb5.setChecked(false);
                }
            }
        });
        cb4.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
                if(arg1)
                { try
                { double a=Double.parseDouble(et1.getText().toString());
                    double b=Double.parseDouble(et2.getText().toString());
                    tv.setText("Total: "+df.format(a/b));
                }
                catch(NumberFormatException e)
                { t.setText("Falta dato");  t.show(); }
                    cb1.setChecked(false); cb2.setChecked(false); cb3.setChecked(false);cb5.setChecked(false);
                }
            }
        });

        cb5.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
                if(arg1)
                { try
                { double a=Double.parseDouble(et1.getText().toString());
                    double b=Double.parseDouble(et2.getText().toString());
                    tv.setText("Total: "+df.format(Math.pow(a,b)));
                }
                catch(NumberFormatException e)
                { t.setText("Falta dato");  t.show(); }
                    cb1.setChecked(false); cb2.setChecked(false); cb3.setChecked(false); cb4.setChecked(false);
                }
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        return true;
    }

}
