## Opis rada aplikacije
 

![image](https://user-images.githubusercontent.com/105864348/170102796-82bfbaa6-8c84-441b-bf4c-3d63c98d69ac.png)

Kada se klikne na aplikaciju otvori se fragment koji traje dvije sekunde te fragment nestane nakon što istekne to vrijeme. Poslije toga se otvara fragment koji sadrži listu gradova koji su prethodno dodani. Kada početni fragment nestane ne može se pomoću back buttona vratiti na taj fragment.


![image](https://user-images.githubusercontent.com/105864348/170103186-9a1ef968-651a-42de-ac23-ba3ab1e23fed.png)
![image](https://user-images.githubusercontent.com/105864348/170103200-e0d2444d-ebf8-4c45-ad23-a98c21699d24.png)

Fragment sa listom gradova  sadrži Recyclier view u kojem su prikazani gradovi koji su već dodani. U dnu se nalaze 3 dugmeta. Dugme koje na sebi ima korpu omogućava da se obrišu svi gradovi. Nakon klika na to dugme pojavi se alert kojim se treba potvrditi brisanje svih gradova. Zatim se tu nalazi dugme za najkraću putanju koje klikom vodi na sljedeći fragment u kojem se računa najkraći put od grada koji je prvi dodan u listu. Dugme koje na sebi ima + služi za odlazak na fragment gdje se otvara forma pomoću koje se dodaje grad. Ukoliko se klikne na grad vodi se na na fragment u kojem su prikazani ostali detalji o gradu. Na ovom fragmentu se nalazi i slide menu koji se otvara klikom na ikonicu u gornjem desnom ćošku ili povlačenjem sa lijeve strane. U njemu se nalazi jedna item koji vodi na prikazivanje informacija o aplikaciji.

![image](https://user-images.githubusercontent.com/105864348/170103382-f1cf9462-36e7-4efc-b76a-fd208dce5fc5.png)

Nakon klika na grad i otvaranja sljedeceg fragmenta prikazani su detalji o tom gradu. Pored prikaza detalja o tom gradu ovaj fragment sadrzi i button-e kojim se može izbrisati selektovan grad, te dugme koje vodi na mapu i markira se oznaka na dijelu mape gdje se selektovan grad nalazi. Grad se prikazuje u Google mapsu. U header menu-u se nalazi up-button koji nas vodi na listu gradova i nalazi se share button kojim se šalje predefinisana poruka.  U predefinisanoj poruci se nalaze latituda i longituda grada čiji su detalji prikazani na mapi.    Takođe fragment u kojem se nalazi prikaz grada na mapi sadrži up-button čijim klikom se vraćamo na detaljne informacije o tom gradu.


![image](https://user-images.githubusercontent.com/105864348/170103505-e5b9daeb-c65b-4ae4-ad24-4b55f63cad84.png)
![image](https://user-images.githubusercontent.com/105864348/170103521-5f11e702-25c6-4ea2-86c1-de2baf0a9e5f.png)

Klikom na „About app“ item u slide menu-u otvara se fragment u kojem su napisani neki detalji o aplikaciji. Takođe i ovaj fragment sadži up button čiji klik vodi na listu gradova.


![image](https://user-images.githubusercontent.com/105864348/170103608-648511e4-8fb2-4a0c-9450-43a0e65dfa85.png)

U fragment za dodavanje grada vodi nas dugme koje na sebi sadrži +. Za grad se dodaje naziv grada, država, latituda, longituda, kratak opis. Nakon klika na dugme „Add City“ grad se dodaje i aplikacija nas opet vraća na listu gradova gdje je pored prethodnih prikazan i trenutno dodan grad.


![image](https://user-images.githubusercontent.com/105864348/170103693-3c4f75c4-b6f8-469e-89c8-627873e7a95c.png)
![image](https://user-images.githubusercontent.com/105864348/170103713-18f406b7-c7a1-4cf9-b912-77951548393e.png)

U fragment gdje se računa najkraći put se dolazi klikom na dugme „shortest path“. Algoritam se pokrene nakon klika na dugme „Računaj“ te se put ispiše u text-view-u. Takođe ovaj fragment sadži i dogme za prikazivanje putanje na mapi. Ono je disable-ovano na početku te nakon izračunavanja najkraćeg puta se može kliknuti na njega. Klikom na njega otvara se mapa na kojoj je iscrtan najkraći put. Ovaj fragment takođe sadrži up-button čijim klikom se vraćamo na listu gradova. Fragment u kojem se nalazi mapa takođe sadrži up-button čiji klik nas vodi na fragment gdje je izračunat put.


## Arhitektura aplikacije

Aplikacija je pisana u programskom jeziku Kotlin. Okruženje u kojem je pisana je Android Studio. Arhitekturu aplikacije možemo podijeliti u nekoliko dijelova: 
Java folder u kojem se nalazi folder sa bazom, algoritmom(za trazenje najkraćeg puta) i 14 kotlin fajlova koji upravljaju fragmentima 
Folder res  u kojem se nalaze navigacija, layouti, stringovi i boje tj. svi layout-i potrebni za izgleda aplikacije

Glavni dio aplikacije se pokreće u jednoj aktivnosti, a za izgled pojedinačnih dijelova korišteni su fragmenti. Prvenstveno su ubacivani Blank fragmenti u koje su se kasnije ubacivali view-i koji su bili potrebni. Zbog potrebe ubacivanja lokacije grada i prikazivanja putanje na karti korišten je Fragment Google Mapsa.  Aktivnost sadrži navigaciju koja je odvojena u poseban folder i ona  postavlja fragmente pri prelasku sa jednog dijela aplikacije na drugi. 
Za potrebe slide menua korišten je resurs Menu. Tokom pisanja aplikacije javila se potreba da se varijable prebacuju iz jednog fragmenta u drugi te su za taj dio korišteni safe argumenti. Zbog zahtjeva da se spašavaju podaci koji se nalaze u aplikaciji ubačena je baza. Korištena baza je SQL-lite. Baza je lokalna i nalazi se na uređaju i jedni način da se izbrišu podaci jeste da se deinstalira aplikacija. Takođe, jedan fragmnet ima drugačiji horizontalni layout od vertikalnog. Zbog mogućnosti unosa većeg teksta javila se potreba za ubacivanjem scroll-viewa, te aplikacija sadži i nekoliko ovakvih xml komponenti. Pored xml komponenti aplikacija sadži i dodatne klase koje su bile potrebne da se olakša rad prilikom  pisanja koda. Za stil aplikacije korištene su 2 palete(jedna za dark mode a druga za light mode).
Aplikacija ima 2 menua:  slide i menu u headeru. Slide menu sadrži sliku u headeru i jedan item. Menu u headeru sadrži up Button, naslov fragmenata i jedan fragment sadži share button. 

## Opis koncepata androida

1) Recyclier view je kontener koji sadrži listu nekih elemenata. Koristi se kada imamo previše itema za prikazati. Razlog uvođenja je jednostavan. Telefonu je teško da učitava sve elmente  pa je osmišljen koncept recyclier viewa. Njegova svrha se može izvući iz naziva. Elementi koji su prikazani na ekranu oni se učitavaju, te kako se dalje lista ti elementi se recikliraju i prikazuju se sljedeci elementi. Razlog uvođenja Recyclier view-a jeste što je izlistavanje elemenata u običnim view-ima bilo previže zahtjevno za uređaje.  Za pravljenje recyclier viewa potrebne su 2 klase. Jedna klasa nasljeđuje View holder i ona sadrži ono što će biti prikazano u listi a druga klasa nasljeđuje Racyclierview.Adapter. 
2) Data klase su posene klase koje se nalaze samo u Kotlinu. Programeri koji su razvijali Kotlin su uočili da većina programera nekada pravi klase koje sadrže samo atribute za čuvanje nekih podataka. Atributi mogu biti bilo kojeg tipa, možemo ih redati tako da budu različitog tipa i može ih biti koliko želimo. Onda su nakon toga razvili data class koja je u osnovi slična običnoj klasi. Pošto sadrži ključnu riječ „data“  ona sadži nekoliko dodatnih funkcija koje projeravaju jesu li dvije klase jednake( equals() / hashCode() ), zatim sadrži i funckiju componentN() koja vraća n-ti atribut onako kako su redani,  zatim copy() koja kopira jednu varijablu u drugu ali da su obje istog tipa „data class-e“ i toString() koja datu klasu konvertuje u string. 
3) Binding koncept Androida je veoma važan. Prvenstveno on prevara u objekat sve viewe od onog xml-a koje  inflate-amo. Može se napraviti poređenje sa DOM-om u javascriptu tj. skoro imaju istu ulogu. Dakle, da nema bindinga mi nebi mogli manipulisati viewima koji se nalaze u xml fajlu. To znači da mi nebi mogli kroz kod promijeniti neke viewe da nije bindinga. On je veoma bitan u fragmenima jer u fragmentima mi ne mozemo korsititi funkciju findViewByID(). Veoma bitan razlog uvođenja bindinga jeste taj što je operacija findViewByID() veoma skupa dok binding nije toliko „skup“. To znači da je puno bolje da uvijek koristimo binding nego findViewByID(). Da bi uopšte koristili binding moramo u xml fajlu čitav sadržaj ubaciti unutar tag-a layout.
4) Fragmenti.
 Samo značenje riječi fragment (odlomljen, nepotpun) daje nam malo širu sliku o fragment. Ukoliko naša aplikacija sadrži više ekrana moguće je svaki dio razdvojiti na poseban fragment te ih ubacivati po potrebi. Stariji način prebacivanja sa ekrana na ekran je bio da se prebacivalo sa aktivnosti na aktivnost ali se potreba za tim izgubila I onda su uvedeni fragmenti. Da bi mogli uopšte raditi sa fragmentim moramo imati navigaciju u našoj aplikaciji.  Navigacija nas navigira od jednog fragmenta do drugog te nam omogućava da definiramo kako će se ponašati onda kad se kline dugme za nazad. Navigacija se sastoji od 3 dijela. Prvi dio je Navigation graph. To je xml fajl koji sadrži sve veze u našoj navigaciji, tj. sve akcije koje će se dešavati nad fragmentima. Većinom se uređuje pomoću Design moda. Drugi dio je NavHost koji predstavlja jedan prazan kontener. Treći dio je NavController  koji upravlja svim prebacivanjima sa fragmenta na fragment. On je glavni dio naše navigacije I bez njega se ne bi mogli prebacivati sa jednog na drugi fragment.  Za prabacivanje u drugi fragment potrebno je naci NavController, a to se radi pomoću  nekog view-a jer on jedino može naći navControlller koji nas prebacuje na drugi fragment.
5) Safe-args
Nekada se javi potreba da prebacimo podatke iz jednog fragmenta u drugi. Ovaj problem se rješava pomoću jednostavnog koncepta koji se naziva safe-args.  Argumenti se prosljeđuju iz jednog fragmenta u drugi veoma jednsoatvno. Najprije se mora u fragment koji ce primati vriejdnsoti moraju dati naziv za argumente I tip. Veoma je važno da se specificira tip I podaci koji se prosljeđuju moraju biti strikto istog tipa. Onda se dalje umjesto traženja akcije pomoću id-a koriste direkcije. Kroz direkciju se proslijede argumenti koji će biti primljeni u fragment. Ti argumenti se jednsoatvno izvuku iz Bundle-a u fragment prema kojem se salju.

6) Jedan od koncepata Android frameworka je I lifecycle. Lifecycle imaju aktivnosti I fragmenti. Pošto je koncept analogan I za aktivnosti I za fragmente, ovdje ćemo razmotriti lifecycle aktivnosti. Aktivnost prolazi kor sljedeće faze: 
-Create 
-Start 
-Resume 
-Destroy 
-Initialized 
Prilikom prelaska iz jedne u drugu fazu pozivaju se sljedeće callback funkcije: 
---OnCreate – prilikom kreiranja aktivnosti 
---OnStart – kada aktivnost postane vidljiva na ekranu 
---OnRestart – aktivnost je stavljena u pozadinu, te prilikom njenog vraćanja iz pozadine prvo se pokreće        onRestart (dakle prilikom pokretanja aplikacije se poziva onCreate, a prilikom vraćanja iz pozadine  onRestart) 
---OnResume – kada aktivnost dobije fokus (postane klikabilna I sl) 
---OnPause – kada aplikacija izgubi fokus 
---OnStop – kada aplikacija bude stavljena u pozadinu I više nije vidljiva na ekranu 
---OnDestroy – priliko uništavanja aktivnosti. 

Funkcije onCreate te onDestroy mogu biti pozvane samo jednom tijekom životnog ciklusa aktivnosti. Ostale funkcije mogu biti pozvane više puta. 
Prilikom pokretanja aktivnosti/aplikacije pozvane su metode onCreate, onStart te onResume. Kada se aktivnost/aplikacija stavi u pozadinu pozivaju se funckije onPause, onStop, ali ne I onDestroy, jer je aplikacija stavljena samo u pozadinu ali ne I zatvorena. Prilikom vraćanja aplikacije iz pozadine, tj. Njenog ponovnog prikazivanja pozvane su funkcije onRestart,onStart te onResume. Ukoliko zatvorimo aplikaciju poziva se callback funkcija onDestroy.

## Opis klasa aplikacije

Za čuvanje podataka u aplikaciji korištena je biblioteka ROOM koja je napravljena na vrhu SQlite baze podataka. U nastavku prvo navodimo klase potrebno za realizaciju baze podataka I komunikacije sa istom. 

### GradDB 
Klasa GradDB je data klasa koja predstavlja jednu tabelu u bazi podataka. Prije imena klase navedena je ključna riječ Parcelize I klasa nasljeđuje klasu Parcelable kako bi se mogla proslijediti kao argument iz jednog fragmenta u drugi. Ova klasa predstavlja jedan red tabele grad_table te sadrži atribute id, grad, drzava, opis, latituda, longituda. 

### GradDBDao: 
Klasa GradDBDao je klasa pomoću koje komuniciramo sa bazom podataka. Klasa sadži funkcije koje izvršavaju zadate upite. Prije svake funkcije u DAO interfejsu navodimo jednu od ključnih riječi @Insert, @Delete, @Update, @Query. Navođenjem @Insert, @Delete, I imena funkcije kao u nastavku, pozivaju se unaprijed definisane funkcije koje insertuju proslijeđeni objekat u bazu ili ga brišu iz baze. Ukoliko želimo pozvati neki upit koji je složeniji od navedenih, to radimo na sljedeći način: 
Npr.@Query(“select * from grad_table where drzava :=key”) 

### Fun dajGradoveDrzave(key: String): List<GradDB> 
Pozivom funkcije dajGradoveDrzave, dobijamo sve gradove iz baze koji pripadaju državi prosljeđenoj kao parametar.
 
### GradRepositoy 
Ova klasa sasdrži atribut gradDao tipa GradDBDao te live data varijablu readAllData koju inicjaliziramo sa svim gradovima iz baze. Varijabla je tipa LiveData<List<GradDB>> iz razloga što ćemo istu posmatrati u listaGradovaFragment I u zavisnosti od njene promjene ažurirati listu podataka.  Klasa sadrži I funkcije addGrad, deleteAll, deleteCity, koje su suspend funkcije koje pozivamo u klasi GradDBViewModel. Ova klasa nije neophodna, ali je dobra praksa da se uvede u aplikaciju.  

### GradDBViewModel 
Klasa GradDBViewModel ima dvije varijable readAllData tipa LiveData<List<GradDB>> te repository tipa GradRepository koja nam služi da komuniciramo sa bazom podataka.  
Prilikom pravljena instance ove klase, pravi se baza ukoliko ona ne postoji, te ukoliko postoji vrati se instanca već napravljene baze podataka. Klasa sadrži funckije addGrad, deleteAll, deleteCity, koje u korutinama pozivaju suspend funkcije iz klase GradReposotory.  
Varijabla readAllData je tipa LiveData iz razloga što ćemo je posmatrati u klasi ListaGradovaFragment te na svaku njenu promjenu(ubacivanjem podataka u bazu ili brisanjem gradova) ažurirati listu gradova.  


### ListaGradovaFragment: 
Ova klasa ima varijable gradViewModel tipa GradDBViewModel pomoču koje komuniciramo sa bazom podataka. U ovoj klasi posmatramo varijablu readAllData klase GradDBViewModel te u zavisnosti od promjena u bazi, ažuriramo listu. Klikom na dugme za dodavanje grada, otvara se novi fragment u kojem se unose neophodni podaci I dodaje grad u bazu. Klikom na brisanje svih gradova, iz baze podataka se brišu svi dodani gradovi. Klikom na neki od pojedinačnih gradova prikazanih u recycle viewu, otvara se fragment sa prikazom detalja grada. 
 
### ListaGradova 
Ova klasa ima jedan atribut tipa List<GradDB>. Napravljena je iz razloga kako bi iz jednog fragmenta mogli proslijediti listu gradova u drugi fragment.  

### Algoritam 
Klasa algoritam ima jedan atribut lista koji predstavlja listu gradova za koju želimo računati najkraći put. Sadrži varijable pocetniGrad koju inicijaliziramo na prvi element atributa lista.  
Varijabla minimalanPut predstavlja dosad najkraću pronađenu udaljenost I tipa je MutableLiveData<Double> 
Varijabla najkraciPut je tipa mutableLiveData<List<GradDB>>. Predstavlja najkraći put nadđen za prosljeđenu listu gradova. Ova varijabla je live data iz razloga što je posmatramo u klasi NajkraciPutFragment I u zavisnosti od njene promjene, vršimo prikaz trenutno najboljeg puta. 
Klasa  sadži funkcije najkraciPut() koja poziva funkciju permutacije() koja pronalazi najkraci put za prosljeđenu listu. Funkcija udaljenost računa udaljenost između dvije tačke zadane preko koordinata na karti(preko latitude I longitude).
 
 
### NajkraciPutFragment
Klasa NajkraciPutFragment predstavlja fragement do kojeg dolazimo preko listaGradovaFragment. Navigiranjem u NajkraciPutFragment prosljeđuje se lista dodanih gradova za koju će se računati algoritam. Ova klasa ima varijablu tipa Algoritam koju pravimo sa listom prosljeđenih gradova. Klasa sadrži dugme racunaj, čijim klikom se pokreće algoritam za računanje najkraćeg puta, te se najkraći put ispisuje na ekran. Nakon što je put nađen, moguće je isti prikazati na karti klikom na dugme prikaziPutNaKarti. Ukoliko algoritam nije pokrenut tj. Put nije nađen, klikom na dugme prikaziPutNaKarti prikazuje se alert sa obavještenjem da je prvo potrebno izračunati put da bi isti bio prikazan.  
 
 
### TitleFragment
Klasa TitleFragment predstavlja uvodni fragment u aplikaciji, koji sadži logo aplikacije sa nazivom I koji se sklanja nakon dvije sekunde od pokretanja aplikacije.  

### GradAdapter: RecyclerView.Adapter<GradAdapter.GradViewHolder>() 
Ova klasa služi da postavi recycler view. Sadrži jedan atribut koji predstavlja listu koja ce biti prikazana u recyclier viewu. Lista je tipa GradDB koja je data klasa. Sadrži šest atributa koji su potrebi da se jedan grad spasi u bazu i prikaže na recyclier viewu. Ova klas anasljeđuje klasu Adapter  koji je tipa GradAdapter.GradViewHolder. Klasa GradViewHolder nam služi da posatvimo jedan item u recyclier view-u. Ta klasa sadži samo one atribute koje ćemo mijenjati u Item-u RecyclerView-a. Item se nalazi u u xml fajlu i on se napravi kao obicni xml. 
Veoma bitna funkcija koja se nalazi u klasi GradAdapter je override fun onBindViewHolder(holder: GradViewHolder, position: Int).  Ova nam funkcija sluzi da uzmemo poziciju našeg elementa u listi za Recycler View i postavimo jedan element na tu poziciju. Pozicija se dobiva iz atributa kojeg klasa prima. Isto tako je bitan zbog postavljaja onCLickListenera koji nas klikom na view vodi na detalje o gradu.
Pošto ova klasa služi za postavljanje RecyclerView-a varijabla ove klase se negdje mora definirati. To se definira u fragmentu u kojem postavljamo RecyclerView. Potrebo je pronaći RecyclerView i posatvili njegov adapter na ovaj što smo mi napravili. Prije toga moramo imati listu koja ide u recyclier view pa atribut adaptera kojeg smo napravili postavim ona tu listu. Sve što je dovoljno je to i onda će ta lisat biti prikazana u Recycler view.  
 
### ListaGradovaFragment : Fragment()
Ovaj fragment sadrži sve što je potrebo za posatvljanje recyclier viewa i slide menua. Zbog slide menua i omogućavanja klika na listu gradova bilo je potrebno citav sadrzaj fragmenta koji sadrzi listu gradova staviti u poseban layout koji se zove drawerLayout. Tada nije bilo moguće korsititi standarni binding pa se u ovom dijelu morao korsititi viewBinding.
 
### Fragmenti PrikazGrada i PrikaziPut 
Ovi fragmenti koriste posebne dijelove koda koje su generisane od strane Google-a i popravljene s ciljem prikazivanja grada na mapi i prikazivanja puta. Latituda i longituda grada koji je prikazan na mapi je proslijeđen pomoću safe-args-a u dvije varijable koje su tipa string pa su naknadno pretvorene u double. U ovom slucaju napravljena je posebna funkcija koja prikazuje oznaku grada na mapi i proslijećena je u liniji  mapFragment?.getMapAsync(callback). Funkcija callback u fragmentu PrikaziPut je direktno implementirana i pošto je samo jedna funkcija koja je proslijeđena kao argument izostavljene su obične zagrade. Prikazivanje grada na karti je moguce pomocu addMarker() funkcije dok se prikaz puta pravi pomocu addPolyline. Put je takođe proslijeđen kroz safe-args-e ali kao jedna klasa i atribut unutar te klase sadzi listu gradova, te se put iscrtava na taj nacin. Jedna linija je spašena u varijablu zbog toga što je planirano da se naknadno stil aplikacije uredi te da se linije iscrtaju drugom bojom ili da se promijeni stil linije.   
 
 Što se tiče foldera values on sadrži potrebne resurse da bi se aplikacija prevela na engleski jezik. Čitava aplikacija je pomoću resursa strings prevedena na engleski jezik. Bilo je potrebno samo napraviti novi  resource file u kojem će se nalaziti stringovi koji imaju isto ime te upisati engleski naziv i ukoliko korisnik promijeni jezik  na telefonu jezik će mu biti onaj koji je promijenjen ukoliko postoji resurs folder u toj aplikaciji za dati jezik.









