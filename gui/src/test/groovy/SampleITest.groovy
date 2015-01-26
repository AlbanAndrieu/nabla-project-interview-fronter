import org.junit.Test

import com.nabla.project.fronter.KataBowling
import com.nabla.project.fronter.api.IGame
import static org.junit.Assert.assertEquals

class SampleITest extends GroovyTestCase {

    @Test
    void testApplicatino() {
        final IGame game = new KataBowling("XXX");

        System.out.println("Score is :\n " + game.getScore() + "\n");

        assertEquals 60, game.getScore()
        
        final Integer score = game.getScore();

        assert "60" == score.toString();
    }

}