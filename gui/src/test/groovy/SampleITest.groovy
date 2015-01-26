import org.junit.Test

import com.nabla.project.fronter.KataService
import com.nabla.project.fronter.api.IGame
import static org.junit.Assert.assertEquals

class SampleITest extends GroovyTestCase {

    @Test
    void testVisma() {
        final IGame game = new KataService("XXX");

        System.out.println("Score is :\n " + game.getScore() + "\n");

        assertEquals 30, game.getScore().size()
        
        final Integer score = game.getScore();

        assert "30" == score.toString();
    }

}