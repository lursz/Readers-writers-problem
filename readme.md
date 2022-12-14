### Readers-Writers problem
_____________________________________

Problem czytelników i pisarzy – klasyczny informatyczny problem synchronizacji dostępu do jednego zasobu (pliku, rekordu bazy danych) dwóch rodzajów procesów: dokonujących i niedokonujących w nim zmian.

W problemie czytelników i pisarzy zasób jest dzielony pomiędzy dwie grupy procesów:</br>
czytelnicy – wszystkie procesy niedokonujące zmian w zasobie,
pisarze – pozostałe procesy.


Jednoczesny dostęp do zasobu może uzyskać dowolna liczba czytelników. Pisarz może otrzymać tylko dostęp wyłączny. Równocześnie z pisarzem dostępu do zasobu nie może otrzymać ani inny pisarz, ani czytelnik, gdyż mogłoby to spowodować błędy.


Test 10 czytelnikow 3 pisarzy, 10 pisarzy 10 czytelnikow
