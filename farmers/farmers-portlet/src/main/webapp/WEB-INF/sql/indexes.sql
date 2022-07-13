create index IX_85EB3F7B on lr_District (isArchive);

create index IX_1A173FF7 on lr_Farmer (inn);
create index IX_EF9CB386 on lr_Farmer (isArchive);
create index IX_30A23361 on lr_Farmer (name);
create index IX_38101BDD on lr_Farmer (registrationDate);

create index IX_39BFC560 on lr_Farmers_Districts (districtId);
create index IX_33F453F5 on lr_Farmers_Districts (farmerId);