import com.github.kondaurovdev.snippets.{ArgsHelper, TryHelper}
import com.github.kondaurovdev.snippets.lang.ProductHelper
import com.github.kondaurovdev.snippets.text.{EncodeHelper, HashHelper, LetterCaseHelper, PrettyHelper}

package object snippets {

  object Snippets {

    import com.github.kondaurovdev.snippets.crypt._

    object Crypt {

      object CryptSecretKey extends CryptSecretKey(Try)
      object Crypter extends Crypter("passwd", CryptSecretKey, Text.Encode, Try)

    }

    object Try extends TryHelper
    object Args extends ArgsHelper()

    object Lang {
      object Product extends ProductHelper()
    }

    object Text {
      object Encode extends EncodeHelper(Try)
      object Hash extends HashHelper(Try)
      object LetterCase extends LetterCaseHelper()
      object Pretty extends PrettyHelper()
    }

  }



}
