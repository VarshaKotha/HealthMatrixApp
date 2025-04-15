package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1 =
            {
                    {"Doctor Name : Dr.Sriram Srikakulapu", "Hospital Address : Apollo Clinic,Manikonda,Hyderabad", "Exp : 5yrs", "Mobile No:9898989898", "600"},
                    {"Doctor Name : Dr.Prasad Pawar", "Hospital Address : Prasad Hospital,Pragathi Nagar,Hyderabad", "Exp : 15yrs", "Mobile No:7898989898", "900"},
                    {"Doctor Name : Dr.Swapnil Kale", "Hospital Address : Idea Clinics,Madhapur", "Exp : 8yrs", "Mobile No:8898989898", "300"},
                    {"Doctor Name : Dr.Deepak Deshmukh", "Hospital Address : Ambicare clinics,Kondapur", "Exp : 6yrs", "Mobile No:9898000000", "500"},
                    {"Doctor Name : Dr.Ashok Panda", "Hospital Address : Dr.Evelyn James Clinic,Bowenpally", "Exp : 7yrs", "Mobile No:7798989898", "800"}
            };
    private String[][] doctor_details2 =
            {
                    {"Doctor Name : Mr.Neelam Patil", "Hospital Address : Nutriline-The Wellness Centre,Banjara Hills", "Exp : 5yrs", "Mobile No:9898989898", "600"},
                    {"Doctor Name : Mr.Jagdish", "Hospital Address : Unique Homeopathy and Diet Clinic,Manikonda", "Exp : 15yrs", "Mobile No:7898989898", "900"},
                    {"Doctor Name : Ms.Neeraja Kale", "Hospital Address : Nutripoint Nutrition Clinic,Kondapur", "Exp : 8yrs", "Mobile No:8898989898", "300"},
                    {"Doctor Name : Ms.Mayuri Deshmukh", "Hospital Address :Vibgyor Nutri,Somajiguda ", "Exp : 6yrs", "Mobile No:9898000000", "500"},
                    {"Doctor Name : Ms.Minakshi Pelluri", "Hospital Address : Rainbow Children's Clinic,Kondapur", "Exp : 7yrs", "Mobile No:7798989898", "800"}
            };
    private String[][] doctor_details3 =
            {
                    {"Doctor Name : Dr.Seema Patil", "Hospital Address : Dental 360,Kondapur", "Exp : 4yrs", "Mobile No:9898989898", "200"},
                    {"Doctor Name : Dr.Pankaj Parab", "Hospital Address : National Dental Care,Nallagandla", "Exp : 5yrs", "Mobile No:7898989898", "300"},
                    {"Doctor Name : Dr.Monish Jain", "Hospital Address : Tarnaka Dental Clinic", "Exp : 7yrs", "Mobile No:8898989898", "300"},
                    {"Doctor Name : Dr.Vishal Deshmukh", "Hospital Address : Brite Smiles Dental Clinic,Mehdipatnam", "Exp : 6yrs", "Mobile No:9898000000", "500"},
                    {"Doctor Name : Dr.Shrikant Panda", "Hospital Address : Smile Miles Dental Hospital,Begumpet", "Exp : 7yrs", "Mobile No:7798989898", "600"}
            };
    private String[][] doctor_details4 =
            {
                    {"Doctor Name : Dr.Amol Gawade", "Hospital Address : Archana Hospitals,Madinaguda", "Exp : 5yrs", "Mobile No:9898989898", "600"},
                    {"Doctor Name : Dr.Prasad Pawar", "Hospital Address : Maven Medical Center,Banjara Hills", "Exp : 15yrs", "Mobile No:7898989898", "900"},
                    {"Doctor Name : Dr.Nilesh Kale", "Hospital Address : Anupama Hospitals,KPHB", "Exp : 8yrs", "Mobile No:8898989898", "300"},
                    {"Doctor Name : Dr.Deepak Deshpande", "Hospital Address Vivekananda Hospitals,Begumpet", "Exp : 6yrs", "Mobile No:9898000000", "500"},
                    {"Doctor Name : Dr.Ashok Katta", "Hospital Address : Medicover Hospitals,Hitech City", "Exp : 7yrs", "Mobile No:7798989898", "800"}
            };
    private String[][] doctor_details5 =
            {
                    {"Doctor Name : Dr.Nilesh Borate", "Hospital Address : Medicover Hospitals,Hitech City", "Exp : 5yrs", "Mobile No:9898989898", "1600"},
                    {"Doctor Name : Dr.Pamkaj Pawar", "Hospital Address : Virinchi Hospitals,Banjara Hills", "Exp : 15yrs", "Mobile No:7898989898", "1900"},
                    {"Doctor Name : Dr.Swapnil Lele", "Hospital Address : Prathima Hospitals,Kachiguda", "Exp : 8yrs", "Mobile No:8898989898", "1300"},
                    {"Doctor Name : Dr.Deepak Kumar", "Hospital Address : One Cardiac Centre,Chandra Nagar", "Exp : 6yrs", "Mobile No:9898000000", "1500"},
                    {"Doctor Name : Dr.Ankul Panda", "Hospital Address : Sravani Hospital,Madhapur", "Exp : 7yrs", "Mobile No:7798989898", "1800"}
            };
    TextView tv;
    Button btn;
    String[][] doctor_details = {};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.buttonBMCartBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physicians")==0)
            doctor_details = doctor_details1;
        else
        if(title.compareTo("Dietician")==0)
            doctor_details = doctor_details2;
        else
        if(title.compareTo("Dentist")==0)
            doctor_details = doctor_details3;
        else
        if(title.compareTo("Surgeon")==0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });

        list = new ArrayList();
        for(int i=0;i<doctor_details.length;i++){
            item = new HashMap<String,String>();
            item.put( "line1", doctor_details[i][0]);
            item.put( "line2", doctor_details[i][1]);
            item.put( "line3", doctor_details[i][2]);
            item.put( "line4", doctor_details[i][3]);
            item.put( "line5", "Cons Fees:"+doctor_details[i][4]+"/-");
            list.add( item );
        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
                );
        ListView lst = findViewById(R.id.listViewBMCart);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });
    }
}