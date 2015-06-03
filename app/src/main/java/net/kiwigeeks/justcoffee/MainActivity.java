package net.kiwigeeks.justcoffee;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.Locale;


public class MainActivity extends ActionBarActivity {

    private int quantity = 0;
    private String courtesyMessage = "Thank you for ordering with us!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the button is clicked.
     */

    public void submitOrder(View view) {

        display(quantity);
        if (quantity == 0) warnCustomer();

        else displayPrice(quantity * 5);


    }


    private void warnCustomer() {
        Toast.makeText(getApplicationContext(), "You must order at least one coffee!",
                Toast.LENGTH_LONG).show();
    }

    public void incrementOrder(View view) {

        display(++quantity);

    }


    public void decrementOrder(View view) {

        if (quantity > 0) display(--quantity);
        else warnCustomer();
    }


    /**
     * This method displays the given quantity value on the screen
     *
     * @param number
     */

    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price value on the screen
     *
     * @param number
     */

    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance(Locale.US).format(number) + "\n" + courtesyMessage);


    }

}
