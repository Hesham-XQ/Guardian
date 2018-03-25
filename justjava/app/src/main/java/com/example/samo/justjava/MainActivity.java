/**
 * IMPORTANT: Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 * <p>
 * package com.example.android.justjava;
 */

package com.example.samo.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox whippedCream = findViewById(R.id.whipped);
        boolean hasWhippedCream = whippedCream.isChecked();
        Log.v("mainActivity", "Has Whipped Cream: " + hasWhippedCream);

        CheckBox choclate = findViewById(R.id.choco);
        boolean cho = choclate.isChecked();
        Log.v("mainActivity", "Add chocolate: " + cho);

        EditText txt = findViewById(R.id.edit_text);
        String txtValue = txt.getText().toString();
        Log.v("mainActivity", "Name: " + txtValue);

        int price = calculatePrice( cho , hasWhippedCream) ;

        String priceMessage = "Total: $" + price;
        priceMessage = createOrderSummary(price, hasWhippedCream, cho , txtValue);
        //this method intent to send order summary via email
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(intent.EXTRA_EMAIL ,"exam@gmail.com" );
            intent.putExtra(Intent.EXTRA_SUBJECT, "Just java order for: " + txtValue );
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage );
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }



        displayMessage(priceMessage);

    }


    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }


    private String createOrderSummary(int price, boolean hasWhippedCream, boolean cho , String txtValue) {
        String priceMessage = getString(R.string.order_summary_name , txtValue);
        priceMessage += "\n" + getString(R.string.quantity_java , quantity);
        priceMessage += "\n" + getString(R.string.whipped_cream_java , hasWhippedCream) ;
        priceMessage += "\n" + getString(R.string.add_chocolate , cho);
        priceMessage += "\n"  + getString(R.string.price , price);
        priceMessage += "\n" + getString(R.string.thank_you);
        return priceMessage;

    }


    /*
    whipped cream cost 1$
    chocolate cost 2$
     */
    private int calculatePrice( boolean cho , boolean hasWhippedCream) {
        int basePrice = 5;

        if (hasWhippedCream){
            basePrice = basePrice + 1;
        }

       if (cho) {

            basePrice = basePrice + 2;
        }

        return quantity * basePrice ;
    }

    public void increment(View view) {
        if (quantity==100){
            // Show an error message as a toast
            Toast.makeText(this , "you can't have more than 100 coffees" , Toast.LENGTH_SHORT).show();
            // Exit this method early because there's nothing left to do
            return;
        }
        quantity = quantity + 1;
        displayQuantity(quantity);

    }

    public void decrement(View view) {
        if (quantity==1){
            // Show an error message as a toast
            Toast.makeText(this , "you can't have less than 1 coffee" , Toast.LENGTH_SHORT).show();
            // Exit this method early because there's nothing left to do
            return;
        }

        quantity = quantity - 1;
        displayQuantity(quantity);

    }



    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }




}
