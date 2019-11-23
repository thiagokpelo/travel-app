package dev.thiagokpelo.viagens.ui.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import dev.thiagokpelo.viagens.R;
import dev.thiagokpelo.viagens.model.Package;
import dev.thiagokpelo.viagens.utils.CurrencyUtil;
import dev.thiagokpelo.viagens.utils.DateUtil;
import dev.thiagokpelo.viagens.utils.ResourceUtil;

public class SummaryPaymentActivity extends AppCompatActivity {

    public static final String APPBAR_TITLE = "Resumo da compra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary_payment);

        setTitle(APPBAR_TITLE);

        populatePackageSelected();
    }

    private void populatePackageSelected() {
        Intent intent = getIntent();

        if (intent.hasExtra(PackageConstants.PACKAGE_KEY)) {
            final Package packageSelected = (Package) intent.getSerializableExtra(PackageConstants.PACKAGE_KEY);
            populateProperties(packageSelected);
        }
    }

    private void populateProperties(Package item) {
        showImage(item);
        showLocal(item);
        showDate(item);
        showPrice(item);
    }

    private void showImage(Package item) {
        ImageView image = findViewById(R.id.summary_payment_package_image);
        Drawable drawable = ResourceUtil.getDrawable(this, item.getImage());
        image.setImageDrawable(drawable);
    }

    private void showLocal(Package item) {
        TextView local = findViewById(R.id.summary_payment_package_local);
        local.setText(item.getLocal());
    }

    private void showDate(Package item) {
        TextView date = findViewById(R.id.summary_payment_package_date);
        String daysFormat = DateUtil.periodToString(item.getDays());
        date.setText(daysFormat);
    }

    private void showPrice(Package item) {
        TextView price = findViewById(R.id.summary_payment_package_price);
        String priceFormat = CurrencyUtil.brazilFormat(item.getPrice());
        price.setText(priceFormat);
    }
}
