create table lr_District (
	districtId LONG not null primary key,
	name VARCHAR(75) null,
	code_ INTEGER,
	isArchive BOOLEAN
);

create table lr_Farmer (
	farmerId LONG not null primary key,
	name VARCHAR(75) null,
	legalForm VARCHAR(75) null,
	inn LONG,
	kpp INTEGER,
	ogrn LONG,
	districtId LONG,
	registrationDate DATE null,
	isArchive BOOLEAN
);

create table lr_Farmers_Districts (
	districtId LONG not null,
	farmerId LONG not null,
	primary key (districtId, farmerId)
);