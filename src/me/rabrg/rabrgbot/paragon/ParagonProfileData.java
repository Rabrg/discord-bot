package me.rabrg.rabrgbot.paragon;

import java.util.List;

public final class ParagonProfileData {

    private final int id;
    private final String name;
    private final boolean privacyEnabled;
    private final List<GameModeStats> stats;

    public ParagonProfileData(int id, String name, boolean privacyEnabled, List<GameModeStats> stats) {
        this.id = id;
        this.name = name;
        this.privacyEnabled = privacyEnabled;
        this.stats = stats;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isPrivacyEnabled() {
        return privacyEnabled;
    }

    public List<GameModeStats> getStats() {
        return stats;
    }

    @Override
    public String toString() {
        for (final GameModeStats stats : getStats()) {
            if (stats.getMode() == 4) {
                return "Username: " + name + "\n"
                        + "Elo: " + stats.getElo() + "\n"
                        + "Percentile: " + stats.getPercentile() + "\n"
                        + "Wins: " + stats.getWins() + "\n"
                        + "Losses: " + (stats.getGamesPlayed() - stats.getWins()) + "\n"
                        + "Win/loss: " + (((double) stats.getWins()) / stats.getGamesPlayed()) + "\n"
                        + "Kills: " + stats.getKills() + "\n"
                        + "Assists: " + stats.getAssists() + "\n"
                        + "Deaths: " + stats.getDeaths() + "\n"
                        + "Kill assist/death: " + (((double) stats.getKills() + stats.getAssists()) / stats.getDeaths());
            }
        }
        return "No data found";
    }

    public class GameModeStats {

        private final int mode;
        private final int gamesPlayed;
        private final double elo;
        private final int wins;
        private final int kills;
        private final int deaths;
        private final int assists;
        private final int towers;
        private final int rank;
        private final double percentile;

        public GameModeStats(final int mode, final int gamesPlayed, final double elo, final int wins, final int kills, final int deaths, final int assists, final int towers, final int rank, final double percentile) {
            this.mode = mode;
            this.gamesPlayed = gamesPlayed;
            this.elo = elo;
            this.wins = wins;
            this.kills = kills;
            this.deaths = deaths;
            this.assists = assists;
            this.towers = towers;
            this.rank = rank;
            this.percentile = percentile;
        }

        public int getMode() {
            return mode;
        }

        public int getGamesPlayed() {
            return gamesPlayed;
        }

        public double getElo() {
            return elo;
        }

        public int getWins() {
            return wins;
        }

        public int getKills() {
            return kills;
        }

        public int getDeaths() {
            return deaths;
        }

        public int getAssists() {
            return assists;
        }

        public int getTowers() {
            return towers;
        }

        public int getRank() {
            return rank;
        }

        public double getPercentile() {
            return percentile;
        }
    }
}
