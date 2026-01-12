package cn.navitool.view;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cn.navitool.R;
import cn.navitool.managers.AppLaunchManager;

public class AppListAdapter extends RecyclerView.Adapter<AppListAdapter.ViewHolder> {

    private final List<AppLaunchManager.AppInfo> mApps;
    private final PackageManager mPackageManager;
    private final OnAppClickListener mListener;

    public interface OnAppClickListener {
        void onAppClick(AppLaunchManager.AppInfo appInfo);
    }

    public AppListAdapter(Context context, List<AppLaunchManager.AppInfo> apps, OnAppClickListener listener) {
        this.mApps = apps;
        this.mPackageManager = context.getPackageManager();
        this.mListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_app_icon, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AppLaunchManager.AppInfo appInfo = mApps.get(position);
        holder.tvAppName.setText(appInfo.name);

        try {
            Drawable icon = mPackageManager.getApplicationIcon(appInfo.packageName);
            holder.ivAppIcon.setImageDrawable(icon);
        } catch (PackageManager.NameNotFoundException e) {
            holder.ivAppIcon.setImageResource(android.R.drawable.sym_def_app_icon);
        }

        holder.itemView.setOnClickListener(v -> {
            if (mListener != null) {
                mListener.onAppClick(appInfo);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mApps.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivAppIcon;
        TextView tvAppName;

        ViewHolder(View itemView) {
            super(itemView);
            ivAppIcon = itemView.findViewById(R.id.ivAppIcon);
            tvAppName = itemView.findViewById(R.id.tvAppName);
        }
    }
}
