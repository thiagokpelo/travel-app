package dev.thiagokpelo.viagens.ui.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import dev.thiagokpelo.viagens.R;
import dev.thiagokpelo.viagens.model.Package;
import dev.thiagokpelo.viagens.utils.CurrencyUtil;
import dev.thiagokpelo.viagens.utils.DateUtil;
import dev.thiagokpelo.viagens.utils.ResourceUtil;

public class PackageSummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_summary);

        setTitle("Resumo do pacote");

        Package packageSP = new Package("São Paulo", "sao_paulo_sp", 2, new BigDecimal("243.99"));

        TextView local = findViewById(R.id.package_summary_local);
        local.setText(packageSP.getLocal());

        ImageView banner = findViewById(R.id.package_summary_banner);
        Drawable drawable = ResourceUtil.getDrawable(this, packageSP.getImage());
        banner.setImageDrawable(drawable);

        TextView days = findViewById(R.id.package_summary_days);
        String daysFormat = DateUtil.daysInTextFormat(packageSP.getDays());
        days.setText(daysFormat);

        TextView price = findViewById(R.id.package_summary_price);
        String priceFormat = CurrencyUtil.brazilFormat(packageSP.getPrice());
        price.setText(priceFormat);


        TextView date = findViewById(R.id.package_summary_date);
        Calendar startDate = Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.DATE, packageSP.getDays());

        SimpleDateFormat dateBrazilFormat = new SimpleDateFormat("dd/MM");
        String startDateFormatted = dateBrazilFormat.format(startDate.getTime());
        String endDateFormatted = dateBrazilFormat.format(endDate.getTime());

        String fullDate = startDateFormatted
                + " - " + endDateFormatted
                + " de " + endDate.get(Calendar.YEAR);

        date.setText(fullDate);
    }
}
