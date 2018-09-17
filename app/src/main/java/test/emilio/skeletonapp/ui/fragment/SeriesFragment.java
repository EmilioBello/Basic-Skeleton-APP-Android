package test.emilio.skeletonapp.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import test.emilio.skeletonapp.BR;
import test.emilio.skeletonapp.MyApp;
import test.emilio.skeletonapp.R;
import test.emilio.skeletonapp.ui.adapter.CommonAdapter;
import test.emilio.skeletonapp.ui.viewmodel.SeriesViewModel;

public class SeriesFragment extends BaseFragment {

    private CommonAdapter adapter;
    private RecyclerView rvSerie;

    private List<Object> viewModels = new ArrayList<>();
    private SeriesViewModel item;


    @Override
    protected void mapUI(View view) {
        rvSerie = (RecyclerView) view.findViewById(R.id.rvSerie);
    }

    @Override
    protected void init() {
        initializeRecyclerView();
        //initializePresenter();
    }

    @Override
    protected String getTitle() {
        return "Test";
    }

    private void initializeRecyclerView() {
        //Create dump elements
        createItems();

        //adapter
        adapter = new CommonAdapter(viewModels, getContext(), R.layout.row_serie, BR.serie);
        rvSerie.setAdapter(adapter);

        //layout
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MyApp.getContext(), LinearLayoutManager.VERTICAL, false);
        rvSerie.setLayoutManager(layoutManager);
        rvSerie.setHasFixedSize(true);
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_series;
    }

    private void createItems(){
        for(int i = 0; i < 10; i++){
            SeriesViewModel item = new SeriesViewModel();
            item.setName(""+i);
            viewModels.add(item);
        }
    }
}
