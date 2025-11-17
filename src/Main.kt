fun main() {
    val alphabet = listOf(
        'А','Б','В','Г','Д','Е','Ё','Ж','З','И','Й','К','Л','М','Н','О','П',
        'Р','С','Т','У','Ф','Х','Ц','Ч','Ш','Щ','Ь','Ы','Ъ','Э','Ю','Я'
    )

    val alphabetMap = alphabet.mapIndexed { index, c -> c.uppercaseChar() to index }.toMap()
    val alphabetSize = alphabet.size

    val keyword = "ДУБ"
    val message = "ПОСЛАНИЕ"

    val messageChars = message.uppercase().toCharArray()
    val keyShifts = keyword.uppercase().map { c -> alphabetMap[c] ?: 0 }
    val encrypted = StringBuilder()

    for ((index, ch) in messageChars.withIndex()) {
        val shift = keyShifts[index % keyShifts.size]
        val currentIdx = alphabetMap[ch] ?: continue
        val newIdx = (currentIdx + shift + alphabetSize) % alphabetSize
        encrypted.append(alphabet[newIdx])
    }
    println("Зашифрованное сообщение: $encrypted")
}