package dev.thiagokpelo.viagens.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import dev.thiagokpelo.viagens.R;
import dev.thiagokpelo.viagens.model.Package;
import dev.thiagokpelo.viagens.utils.CurrencyUtil;

public class PaymentActivity extends AppCompatActivity {

    public static final String APPBAR_TITLE = "Pagamento";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        setTitle(APPBAR_TITLE);

        populatePackageSelected();
    }

    private void populatePackageSelected() {
        Intent intent = getIntent();

        if (intent.hasExtra(PackageConstants.PACKAGE_KEY)) {
            final Package packageSelected = (Package) intent.getSerializableExtra(PackageConstants.PACKAGE_KEY);
            showPrice(packageSelected);
            buttonConfig(packageSelected);
        }
    }

    private void buttonConfig(final Package packageSelected) {
        Button button = findViewById(R.id.payment_call_to_action);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSummaryPayment(packageSelected);
            }
        });
    }

    private void goToSummaryPayment(Package item) {
        Intent intent = new Intent(PaymentActivity.this, SummaryPaymentActivity.class);
        intent.putExtra(PackageConstants.PACKAGE_KEY, item);
        startActivity(intent);
    }

    private void showPrice(Package item) {
        TextView price = findViewById(R.id.payment_price);
        price.setText(CurrencyUtil.brazilFormat(item.getPrice()));
    }
}
