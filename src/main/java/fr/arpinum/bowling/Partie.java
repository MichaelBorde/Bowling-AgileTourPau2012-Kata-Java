package fr.arpinum.bowling;

import java.util.ArrayList;
import java.util.List;


public class Partie {
	public void nouveauLancer(int quilles) {
		lancers.add(quilles);
	}

	public int score() {
		int résultat = 0;
		int indiceCarreau = 0;
		for (int i = 0; i < 10; i++) {
			if (estStrike(indiceCarreau)) {
				résultat += 10 + bonusStrike(indiceCarreau);
				indiceCarreau++;
			}
			else {
				résultat += scoreCarreau(indiceCarreau);
				if (estSpare(indiceCarreau)) {
					résultat += bonusSpare(indiceCarreau);
				}
				indiceCarreau += 2;
			}
		}
		return résultat;
	}

	private int bonusStrike(int indiceCarreau) {
		return lancers.get(indiceCarreau + 1) + lancers.get(indiceCarreau + 2);
	}

	private boolean estStrike(int indiceCarreau) {
		return lancers.get(indiceCarreau) == 10;
	}

	private int scoreCarreau(int indiceCarreau) {
		return lancers.get(indiceCarreau) + lancers.get(indiceCarreau + 1);
	}

	private boolean estSpare(int indiceCarreau) {
		return lancers.get(indiceCarreau) + lancers.get(indiceCarreau + 1) == 10;
	}

	private Integer bonusSpare(int indiceCarreau) {
		return lancers.get(indiceCarreau + 2);
	}

	List<Integer> lancers = new ArrayList<Integer>();
}
