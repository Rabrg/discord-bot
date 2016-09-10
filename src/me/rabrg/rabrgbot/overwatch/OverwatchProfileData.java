package me.rabrg.rabrgbot.overwatch;

import com.google.gson.annotations.SerializedName;

public final class OverwatchProfileData {

    private final String username;
    private final int level;
    @SerializedName("games")
    private final GameRecords gameRecords;
    private final Playtime playtime;
    private final String avatar;
    private final Competitive competitive;
    private final String levelFrame;
    private final String star;

    public OverwatchProfileData(final String username, final int level, final GameRecords gameRecords,
                                final Playtime playtime, final String avatar, final Competitive competitive,
                                final String levelFrame, final String star) {
        this.username = username;
        this.level = level;
        this.gameRecords = gameRecords;
        this.playtime = playtime;
        this.avatar = avatar;
        this.competitive = competitive;
        this.levelFrame = levelFrame;
        this.star = star;
    }

    public String getUsername() {
        return username;
    }

    public int getLevel() {
        return level;
    }

    public GameRecords getGameRecords() {
        return gameRecords;
    }

    public Playtime getPlaytime() {
        return playtime;
    }

    public String getAvatar() {
        return avatar;
    }

    public Competitive getCompetitive() {
        return competitive;
    }

    public String getLevelFrame() {
        return levelFrame;
    }

    public String getStar() {
        return star;
    }

    @Override
    public String toString() {
        final String title = "!===";
        return "Username: " + username + "\n"
                + "Level : " + level + "\n"
                + "Ranking: " + getCompetitive().getRank() + "\n"
                + "Quickplay:\n"
                + "    Time: " + getPlaytime().getQuick() + "\n"
                + "    Wins: " + getGameRecords().getQuick().getWins() + "\n"
                + "    Losses: " + getGameRecords().getQuick().getLost() + "\n"
                + "Competitive:\n"
                + "    Time: " + getPlaytime().getCompetitive() + "\n"
                + "    Wins: " + getGameRecords().getCompetitive().getWins() + "\n"
                + "    Losses: " + getGameRecords().getCompetitive().getLost() + "\n";
    }

    public final class GameRecords {

        private final GameRecord quick;
        private final GameRecord competitive;

        public GameRecords(final GameRecord quick, final GameRecord competitive) {
            this.quick = quick;
            this.competitive = competitive;
        }

        public GameRecord getQuick() {
            return quick;
        }

        public GameRecord getCompetitive() {
            return competitive;
        }
    }

    public final class GameRecord {

        private final int wins;
        private final int lost;
        private final int played;

        public GameRecord(final int wins, final int lost, final int played) {
            this.wins = wins;
            this.lost = lost;
            this.played = played;
        }

        public int getWins() {
            return wins;
        }

        public int getLost() {
            return lost;
        }

        public int getPlayed() {
            return played;
        }
    }

    private final class Playtime {

        private final String quick;
        private final String competitive;

        public Playtime(final String quick, final String competitive) {
            this.quick = quick;
            this.competitive = competitive;
        }

        public String getQuick() {
            return quick;
        }

        public String getCompetitive() {
            return competitive;
        }
    }

    private final class Competitive {

        private final String rank;
        @SerializedName("rank_img")
        private final String rankImage;

        public Competitive(final String rank, final String rankImage) {
            this.rank = rank;
            this.rankImage = rankImage;
        }

        public String getRank() {
            return rank;
        }

        public String getRankImage() {
            return rankImage;
        }
    }
}
