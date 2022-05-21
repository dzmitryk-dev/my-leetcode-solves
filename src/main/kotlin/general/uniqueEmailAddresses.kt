fun numUniqueEmails(emails: Array<String>): Int {
    val filtered = emails.map { email ->
        val (localName, domainName) = email.split("@")
        val plusIndex = localName.indexOf('+')
        val filteredLocalName = if (plusIndex > 0) {
            localName.substring(0, plusIndex)
        } else {
            localName
        }.filterNot { it ==  '.' }
        "$filteredLocalName@$domainName"
    }.toSet()
    return filtered.size
}