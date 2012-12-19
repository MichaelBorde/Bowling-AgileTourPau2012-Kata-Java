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
		nouveauxLancers(20, 0);

		assertThat(partie.score()).isEqualTo(0);
	}

	@Test
	public void jePeuxObtenirLeScoreDUnePartieModeste() {
		nouveauxLancers(20, 1);

		assertThat(partie.score()).isEqualTo(20);
	}

	@Test
	public void leScorePrendEnCompteLeSpare() {
		nouveauSpare();
		nouveauxLancers(1, 1);
		nouveauxLancers(17, 0);

		assertThat(partie.score()).isEqualTo(12);
	}

	@Test
	public void leScorePrendEnCompteLeStrike() {
		nouveauStrike();
		nouveauxLancers(1, 1);
		nouveauxLancers(1, 2);
		nouveauxLancers(16, 0);

		assertThat(partie.score()).isEqualTo(16);
	}

	@Test
	public void unSecondLancerQuiAbattraitToutesLesQuillesNEstPasUnStrike() {
		nouveauxLancers(1, 0);
		nouveauxLancers(1, 10);
		nouveauxLancers(1, 2);
		nouveauxLancers(1, 2);
		nouveauxLancers(16, 0);

		assertThat(partie.score()).isEqualTo(16);
	}

	@Test
	public void leScoreDUnePartieDeStrikesEst300() {
		nouveauxLancers(12, 10);

		assertThat(partie.score()).isEqualTo(300);
	}

	private void nouveauStrike() {
		nouveauxLancers(1, 10);
	}

	private void nouveauSpare() {
		nouveauxLancers(1, 4);
		nouveauxLancers(1, 6);
	}

	private void nouveauxLancers(int lancer, int quilles) {
		for (int i = 0; i < lancer; i++) {
			partie.nouveauLancer(quilles);
		}
	}

	private Partie partie;
}
