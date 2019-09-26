package ashunevich.uniconverter20;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PipeRecyclerViewAdapter extends RecyclerView.Adapter<PipeRecyclerViewAdapter.MyViewHolder> {
//Creating an arraylist of POJO objects


    private ArrayList<PipeRecyclerViewItem> pad_list;
    View view;
    MyViewHolder holder;


    public PipeRecyclerViewAdapter(ArrayList<PipeRecyclerViewItem> data) {
        this.pad_list = data;
    }

    //This method inflates view present in the RecyclerView
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pipe_size_single_item, parent, false);
        holder = new MyViewHolder(view);
        return holder;
    }

    //Binding the data using get() method of POJO object
    @Override
    public void onBindViewHolder(final MyViewHolder rowViewHolder, int position) {
        Resources res = rowViewHolder.itemView.getContext().getResources();
        int rowPos = rowViewHolder.getAdapterPosition();
        if (rowPos == 0) {
            rowViewHolder.inches.setText(res.getString(R.string.nps));
            rowViewHolder.metric.setText(res.getString(R.string.DN));
            rowViewHolder.outsideDim.setText(res.getString(R.string.OD));
            rowViewHolder.inches.setBackgroundResource(R.drawable.rect_table_header);
            rowViewHolder.metric.setBackgroundResource(R.drawable.rect_table_header);
            rowViewHolder.outsideDim.setBackgroundResource(R.drawable.rect_table_header);
        }
        else{
            final PipeRecyclerViewItem list_items = pad_list.get(position);
            rowViewHolder.inches.setText(list_items.getInch());
            rowViewHolder.metric.setText(list_items.getMm());
            rowViewHolder.outsideDim.setText(list_items.getDim());
            rowViewHolder.inches.setBackgroundResource(R.drawable.rect_table);
            rowViewHolder.metric.setBackgroundResource(R.drawable.rect_table);
            rowViewHolder.outsideDim.setBackgroundResource(R.drawable.rect_table);
        }
    }

    //Setting the arraylist
    public void setListContent(ArrayList<PipeRecyclerViewItem> pad_list) {
        this.pad_list = pad_list;
    }

    @Override
    public int getItemCount() {
        return pad_list.size();
    }

    //View holder class, where all view components are defined
    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.inches)
        TextView inches;
        @BindView(R.id.metric)
        TextView metric;
        @BindView(R.id.outsideDim)
        TextView outsideDim;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}



