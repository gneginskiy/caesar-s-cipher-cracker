package cipher.cracker;

import cipher.languages.impls.EnglishSettings;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by Grigory_Neginsky on 08-Feb-17.
 */
public class CipherCrackerTest {
    private static final String MSG_TO_DECODE =
            "Ymj tsqd nrutwyfsy inkkjwjshj nx ymfy ymj ijxnlsjwx tk ymj Ofaf Xbnsl FUN xfb ymj sjji yt uwtanij ymj \"Fhynts\"" +
            " nsyjwkfhj ns ymjnw LZN jqjrjsyx, xt hqfxxjx qnpj ORjszNyjr fsi OGzyyts fwj fqwjfid bnwji yt fhhjuy Fhynts tgojhyx," +
            " fsi ymjd pstb yt hfqq ymj fhyntsUjwktwrji() rjymti tk ymtxj tgojhyx bmjs fs jajsy thhzwx. (Fx tuutxji yt dtz bwnynsl" +
            " qtlnh yt hfqq ymj jcjhzyj() rjymti tk dtzw tbs Ofaf Htrrfsi Ufyyjws hqfxxjx.)\n";
    private static final String DECRYPTED_MSG_EXPECTED =
            "The only important difference is that the designers of the Java Swing API saw the need to provide the \"Action\"" +
            " interface in their GUI elements, so classes like JMenuItem and JButton are already wired to accept Action objects," +
            " and they know to call the actionPerformed() method of those objects when an event occurs. (As opposed to you writing" +
            " logic to call the execute() method of your own Java Command Pattern classes.)\n";
        @Test
        public void cipherCrackingTest() {
            assertEquals(DECRYPTED_MSG_EXPECTED,new CipherCracker(MSG_TO_DECODE,EnglishSettings.getInstance()).getDecodedStrings().get(0));
        }
}
