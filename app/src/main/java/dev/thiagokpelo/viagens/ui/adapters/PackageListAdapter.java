package dev.thiagokpelo.viagens.ui.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import dev.thiagokpelo.viagens.R;
import dev.thiagokpelo.viagens.model.Package;
import dev.thiagokpelo.viagens.ui.activity.PackageListActivity;
import dev.thiagokpelo.viagens.utils.CurrencyUtil;
import dev.thiagokpelo.viagens.utils.DateUtil;
import dev.thiagokpelo.viagens.utils.ResourceUtil;

public class PackageListAdapter extends BaseAdapter {

    private final List<Package> packages;
    private final Context context;

    public PackageListAdapter(List<Package> packages, PackageListActivity context) {
        this.packages = packages;
        this.context = context;
    }

    @Override
    public int getCount() {
        return packages.size();
    }

    @Override
    public Package getItem(int position) {
        return packages.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View inflateView = LayoutInflater
                .from(context)
                .inflate(R.layout.item_package, parent, false);

        Package currentPackage = packages.get(position);

        showLocal(inflateView, currentPackage);
        showImage(inflateView, currentPackage);
        showDays(inflateView, currentPackage);
        showPrice(inflateView, currentPackage);

        return inflateView;
    }

    private void showPrice(View inflateView, Package currentPackage) {
        TextView price = inflateView.findViewById(R.id.package_item_price);
        String currencyValue = CurrencyUtil.brazilFormat(currentPackage.getPrice());
        price.setText(currencyValue);
    }

    private void showDays(View inflateView, Package currentPackage) {
        TextView days = inflateView.findViewById(R.id.package_item_days);
        String daysText = DateUtil.daysInTextFormat(currentPackage.getDays());
        days.setText(daysText);
    }

    private void showImage(View inflateView, Package currentPackage) {
        ImageView image = inflateView.findViewById(R.id.package_item_image);
        Drawable drawableImagePackage = ResourceUtil.getDrawable(context, currentPackage.getImage());
        image.setImageDrawable(drawableImagePackage);
    }

    private void showLocal(View inflateView, Package currentPackage) {
        TextView local = inflateView.findViewById(R.id.package_item_local);
        local.setText(currentPackage.getLocal());
    }
}
