package jsonwithgson.sanjay.com.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by sanjay on 8/11/15.
 */
public class SimpleAdapter extends BaseAdapter {
    private  Context mContext;
    private LayoutInflater inflater;
    private List<Responce.MoviesEntity> movieItem;

    public SimpleAdapter(Context mContext, List<Responce.MoviesEntity> movieItem) {
        this.mContext = mContext;
        this.movieItem = movieItem;
    }

    @Override
    public int getCount() {
        return movieItem.size();
    }

    @Override
    public Object getItem(int position) {
        return movieItem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(inflater == null)
            inflater = (LayoutInflater)mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(convertView == null)
            convertView = inflater.inflate(R.layout.each_list_items,null);

        ImageView image = (ImageView) convertView.findViewById(R.id.image);
        TextView title = (TextView) convertView.findViewById(R.id.title);
        TextView rating = (TextView) convertView.findViewById(R.id.rating);

        Responce.MoviesEntity item = (Responce.MoviesEntity) getItem(position);
        String imageUrl = item.getPosters().getOriginal();
        Picasso.
                with(mContext).
                load(imageUrl).
                into(image);
                title.setText(item.getTitle());
                rating.setText(item.getRatings().getCritics_rating());

        return convertView;
    }
}
