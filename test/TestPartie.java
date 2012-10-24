import static org.fest.assertions.Assertions.*;

import org.junit.Before;
import org.junit.Test;

public class TestPartie {
	@Before
	public void setUp() throws Exception {
		partie = new Partie();
	}

	@Test
	public void jePeuxObtenirLeScoreDUnePartieGoutière() {
		nouveauxLancés(20, 0);

		assertThat(partie.score()).isEqualTo(0);
	}

	@Test
	public void jePeuxObtenirLeScoreDUnePartieModeste() {
		nouveauxLancés(20, 1);

		assertThat(partie.score()).isEqualTo(20);
	}

	@Test
	public void leScorePrendEnCompteLeSpare() {
		nouveauSpare();
		nouveauxLancés(1, 1);
		nouveauxLancés(17, 0);

		assertThat(partie.score()).isEqualTo(12);
	}

	@Test
	public void leScorePrendEnCompteLeStrike() {
		nouveauStrike();
		nouveauxLancés(1, 1);
		nouveauxLancés(1, 2);
		nouveauxLancés(16, 0);

		assertThat(partie.score()).isEqualTo(16);
	}

	@Test
	public void unSecondLancéQuiAbattraitToutesLesQuillesNEstPasUnStrike() {
		nouveauxLancés(1, 0);
		nouveauxLancés(1, 10);
		nouveauxLancés(1, 2);
		nouveauxLancés(1, 2);
		nouveauxLancés(16, 0);

		assertThat(partie.score()).isEqualTo(16);
	}

	@Test
	public void leScoreDUnePartieDeStrikesEst300() {
		nouveauxLancés(12, 10);

		assertThat(partie.score()).isEqualTo(300);
	}

	private void nouveauStrike() {
		nouveauxLancés(1, 10);
	}

	private void nouveauSpare() {
		nouveauxLancés(1, 4);
		nouveauxLancés(1, 6);
	}

	private void nouveauxLancés(int lancés, int quilles) {
		for (int i = 0; i < lancés; i++) {
			partie.nouveauLancé(quilles);
		}
	}

	private Partie partie;
}
