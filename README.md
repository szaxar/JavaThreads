# JavaThreads
Treść zadań
-Thread
Napisac program , w ktorym jeden watek inkrementuje pewna zmienna 100000000 razy, drugi ja dekrementuje 100000000. 
-Thread2
Mamy klika procesów produkujacych wiadomosci (szkielet kodu) i kilka konsumujacych wiadomosci (szkielet kodu) do/z jednoelementowego bufora. Zadaniem jest napisanie klasy Buffer z metodami put i take, tak, aby dostep byl synchronizowany uzywajac monitora Javy dla obiektu klasy Buffer. Kazda wiadomosc jest produkowana przez jednego producenta i konsumowana przez jednego, dowolnego konsumenta.
-Thread3
zaimplementowac semafor binarny za pomoca metod wait i notify/notifyall, uzyc go do synchronizacji wyscigu z Thread
-Thread4
zaimplementowac semafor licznikowy (ogolny) za pomoca metod wait i notify/notifyall. Przetestowac semafor na prostej symulacji sklepu samoobsługowego z ograniczoną ilością koszyków.
-Thread5
Przeanalizuj i przetestuj na swoich producentach i konsumentach monitor BoundedBuffer przeznaczony dla producentow i konsumentow.
-Thread6
Drukarki 
Grupa wątków P (ilosc N) korzysta z M drukarek N>M. Dzialanie wątku
forever{
  Utworz_zadanie_do_druku();
  nr_drukarki=Monitor_Drukarek.zarezerwuj();
  drukuj(nr_drukarki);
  Monitor_Drukarek.zwolnij(nr_drukarki);
}
Napisz monitor Monitor_Drukarek.
-Thread8
Przetwarzanie potokowe z buforem
Bufor o rozmiarze N - wspólny dla wszystkich procesow!
Proces A będacy producentem.
Proces Z będacy konsumentem.
Procesy B, C, ..., Y będace procesami przetwarzajacymi. Każdy proces otrzymuje daną wejściową od procesu poprzedniego, jego wyjscie zas jest konsumowane przez proces następny.
Procesy przetwarzają dane w miejscu, po czym przechodzą do kolejnej komórki bufora i znowu przetwarzają ją w miejscu.
Procesy dzialają z różnymi prędkościami.
-Thread9
Proszę zaimplementować przy użyciu Executor i Future program wykonujący obliczanie zbioru Mandelbrota w puli wątków.
Proszę przetestować szybkość działania programu w zależności od
parametrow wybranego Executora (np. liczba wątków w puli).
implementacji Executora (porownac dzialanie minimum dwoch roznych implementacji Executora)
Czas obliczeń można zwiększać manipulując parametrami problemu, np. liczbą iteracji (MAX_ITER). Czas należy zmierzyć 10 razy dla tego samego przypadku, policzyć średnią i odchylenie standardowe.
