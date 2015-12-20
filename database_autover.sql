create database autover;
use autover;
create table Hersteller(

	Herstellerid int not null auto_increment,
	Hersteller_Name varchar(255),
	Primary key (Herstellerid)
);
create table Modell(

	HerstellerModellid int not null auto_increment,
	Herstellerid int,
	Modell varchar(255),
	Primary key(HerstellerModellid),
	constraint fg_modell_hersteller foreign key (Herstellerid) references  Hersteller(Herstellerid)
);
create table Baujahr(

	Baujahrid int not null auto_increment,
	Baujahr int,
Primary key (Baujahrid)
);
create table Farbe(
		Farbeid int not null auto_increment,
		Farbe varchar(255),
Primary key (Farbeid)
);
create table Tueren(

		Tuerenid int not null auto_increment,
		Tuerenanzahl varchar(255),
Primary key (Tuerenid)
);
create table Leistung(
			Leistungid int not null auto_increment,
			Leistung_in_ps int,

Primary key (Leistungid)
);
create table Kraftstoff(
		Kraftstoffid int not null auto_increment,
		Kraftstofftyp varchar(255),
Primary key (Kraftstoffid)
);
create table Zustand(

		Zustandid int not null auto_increment,
		Zustand varchar(255),


Primary key (Zustandid)
);
create table Auto(
	id int Not null auto_increment,
	Verkaufspreis int,
	HerstellerModellid int,
	Baujahrid int,
	Farbeid int,
	Tuerenid int,
	Leistungid int,
	Kilometerzahl int,
	Kraftstoffid int,
	Zustandid int,
	Beschreibung varchar(255),
	Erstellungsdatum datetime,
Primary key (id),


constraint fg_auto_modell foreign key (HerstellerModellid) references  Modell(HerstellerModellid),
constraint fg_auto_baujahr foreign key (Baujahrid) references Baujahr(Baujahrid),
constraint fg_auto_farbe foreign key (Farbeid) references Farbe(Farbeid),
constraint fg_auto_tueren foreign key (Tuerenid) references Tueren(Tuerenid),
constraint fg_auto_leistung foreign key (Leistungid) references Leistung(Leistungid),
constraint fg_auto_karftstoff foreign key (Kraftstoffid) references Kraftstoff(Kraftstoffid),
constraint fg_auto_zustand foreign key (Zustandid) references Zustand(Zustandid)
 
);
