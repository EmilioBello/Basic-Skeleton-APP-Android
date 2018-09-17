package test.emilio.skeletonapp.model.POJO.entity;

import java.util.ArrayList;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Builder;

@Data
@EqualsAndHashCode(callSuper=false)
public class ADSerie {

    private int code;

    private Date createdAt;
    private Date updatedAt;
    private boolean active;

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
}
