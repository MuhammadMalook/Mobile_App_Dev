package com.example.classactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    //    TextView quantity;
//    TextView summary;
//    CheckBox cream;
  // CheckBox choco;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity6);
        System.out.println("Activity Created");
        textView = findViewById(R.id.textbox);
        System.out.println(getResources().getIdentifier("angry","drawable",getPackageName()) + "\n" + getResources().getResourceEntryName(R.id.button2));


        //task3
//        quantity = findViewById(R.id.quantity);
//        cream = findViewById(R.id.cream);
       //choco = findViewById(R.id.chocolate);
       //choco.performClick();
//        summary = findViewById(R.id.summary);
        //task3

    }


    //task4

    public void numbers(View view) {
        Button btn = (Button) view;
        textView.setText(textView.getText() + btn.getText().toString());
    }

    public void clear(View view) {
        textView.setText("");
    }

    public void operation(View view) {
        Button btnOp = (Button) view;
        String text = textView.getText().toString();
        if (text.contains("+") || text.contains("-") || text.contains("*") || text.contains("/") || text.contains("%"))
            Toast.makeText(this, "You can not use multiple operators", Toast.LENGTH_SHORT).show();
        else
            textView.setText(textView.getText() + btnOp.getText().toString());
    }

    public void equal(View view) {
        String[] numbers = textView.getText().toString().split("-|\\+|x|/|%");
        if (textView.getText().toString().contains("+"))
            textView.setText(textView.getText() + "\n" + (Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1])) + "");
        else if (textView.getText().toString().contains("-"))
            textView.setText(textView.getText() + "\n" + (Integer.parseInt(numbers[0]) - Integer.parseInt(numbers[1])) + "");
        else if (textView.getText().toString().contains("/"))
            textView.setText(textView.getText() + "\n" + (Float.parseFloat(numbers[0]) / Float.parseFloat(numbers[1])) + "");
        else if (textView.getText().toString().contains("x"))
            textView.setText(textView.getText() + "\n" + (Integer.parseInt(numbers[0]) * Integer.parseInt(numbers[1])) + "");
        else if (textView.getText().toString().contains("%"))
            textView.setText(textView.getText() + "\n" + (Integer.parseInt(numbers[0]) % Integer.parseInt(numbers[1])) + "");
    }


    //task3
//    public void increase(View view)
//    {
//        quantity.setText((Integer.parseInt(quantity.getText().toString())+1)+"");
//    }
//    public void decrease(View view)
//    {
//        if(Integer.parseInt(quantity.getText().toString())!=0)
//            quantity.setText((Integer.parseInt(quantity.getText().toString())-1)+"");
//    }
//
//    public void placeOrder(View view)
//    {
//        float totalBill=0;
//        String cr = "no";
//        String ch = "no";
//        if(Integer.parseInt(quantity.getText().toString())!=0)
//        {
//            if(cream.isChecked())
//            {
//                totalBill+=0.5;
//                cr="yes";
//            }
//            if(choco.isChecked())
//            {
//                totalBill+=1;
//                ch = "yes";
//            }
//            totalBill+=Integer.parseInt(quantity.getText().toString())*4;
//            summary.setText("Add whipped cream?"+cr+"\nAdd chocolate?"+ch+"\nQuantity: "+quantity.getText().toString()+"\n\nPrice: "+totalBill+"\nThankyou");
//
//        }
//    }
    //end task33

    //task2
//    public void Eat(View view)
//    {
//        ImageView img = findViewById(R.id.imageView2);
//        Button btn = findViewById(R.id.button17);
//        TextView txt = findViewById(R.id.textView23);
//        img.setImageResource(R.drawable.happy);
//        txt.setText("I'm so full");
//        btn.setText("Done");
//    }

    //end task2

    //task1
//    @Override
//    protected void onStart() {
//        super.onStart();
//        System.out.println("Activity Started");
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        System.out.println("Activity Resumed");
//
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        System.out.println("Activity Paused");
//
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        System.out.println("Activity Stopped");
//
//    }
//
//    @Override
//    protected void onRestart() {
//        super.onRestart();
//        System.out.println("Activity Restarted");
//
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        System.out.println("Activity Destroyed");
//
//    }
//}
}



