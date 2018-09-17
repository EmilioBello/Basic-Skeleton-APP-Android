package test.emilio.skeletonapp.view.viewmodel;

import java.util.ArrayList;

import lombok.Data;
import test.emilio.skeletonapp.model.POJO.entity.ADSerie;

/**
 * Created by Emilio on 07/08/2016.
 */

@Data
public class SeriesViewModel {

    private int code;
    private String name;

    private int season;
    private int totalEpisodes;

    private int seasonProgress;
    private int episodeProgress;

    private boolean downloaded;

    private ArrayList<Integer> listEpisode;

    private boolean complete;
    private int status;

    private String urlAvatar;
    private String urlImageBackground;

    public static SeriesViewModel converterEntitytoViewModel(ADSerie serie) {
        SeriesViewModel viewModel = null;

        viewModel = new SeriesViewModel();

        viewModel.setCode(serie.getCode());
        viewModel.setName(serie.getName());

        viewModel.setSeason(serie.getSeason());
        viewModel.setTotalEpisodes(serie.getTotalEpisodes());

        viewModel.setSeasonProgress(serie.getSeasonProgress());
        viewModel.setEpisodeProgress(serie.getEpisodeProgress());

        viewModel.setDownloaded(serie.isDownloaded());

        viewModel.setListEpisode(serie.getListEpisode());

        viewModel.setComplete(serie.isComplete());
        viewModel.setStatus(serie.getStatus());

        viewModel.setUrlAvatar(serie.getUrlAvatar());
        viewModel.setUrlImageBackground(serie.getUrlImageBackground());

        return viewModel;
    }
}
