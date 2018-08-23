package ru.reksoft.isa.sectorapp.util;

import ru.reksoft.isa.sectorapp.dao.Sector;
import ru.reksoft.isa.sectorapp.repository.SectorRepository;

public class RepoUtil {
    public static void initSectors(final SectorRepository repository) {
        final Sector sector1 = new Sector("Manufacturing", 0);
        repository.save(sector1);

        final Sector sector11 = new Sector("Construction materials", sector1.getId());
        repository.save(sector11);
        final Sector sector12 = new Sector("Electronics and Optics", sector1.getId());
        repository.save(sector12);
        final Sector sector13 = new Sector("Food and Beverage", sector1.getId());
        repository.save(sector13);

        final Sector sector131 = new Sector("Bakery & confectionery products", sector13.getId());
        repository.save(sector131);
        final Sector sector132 = new Sector("Fish & fish products", sector13.getId());
        repository.save(sector132);
        final Sector sector133 = new Sector("Meat & meat products", sector13.getId());
        repository.save(sector133);
        final Sector sector134 = new Sector("Milk & dairy products", sector13.getId());
        repository.save(sector134);
        final Sector sector135 = new Sector("Other", sector13.getId());
        repository.save(sector135);
        final Sector sector136 = new Sector("Sweets & snack food", sector13.getId());
        repository.save(sector136);

        final Sector sector14 = new Sector("Furniture", sector1.getId());
        repository.save(sector14);

        final Sector sector141 = new Sector("Furniture", sector14.getId());
        repository.save(sector141);
        final Sector sector142 = new Sector("Bathroom/sauna", sector14.getId());
        repository.save(sector142);
        final Sector sector143 = new Sector("Bedroom", sector14.getId());
        repository.save(sector143);
        final Sector sector144 = new Sector("Children’s room", sector14.getId());
        repository.save(sector144);
        final Sector sector145 = new Sector("Kitchen", sector14.getId());
        repository.save(sector145);
        final Sector sector146 = new Sector("Living room", sector14.getId());
        repository.save(sector146);
        final Sector sector147 = new Sector("Office", sector14.getId());
        repository.save(sector147);
        final Sector sector148 = new Sector("Other (Furniture)", sector14.getId());
        repository.save(sector148);
        final Sector sector149 = new Sector("Outdoor", sector14.getId());
        repository.save(sector149);
        final Sector sector14A = new Sector("Project furniture", sector14.getId());
        repository.save(sector14A);

        final Sector sector15 = new Sector("Machinery", sector1.getId());
        repository.save(sector15);

        final Sector sector151 = new Sector("Machinery components", sector15.getId());
        repository.save(sector151);
        final Sector sector152 = new Sector("Machinery equipment/tools", sector15.getId());
        repository.save(sector152);
        final Sector sector153 = new Sector("Manufacture of machinery", sector15.getId());
        repository.save(sector153);
        final Sector sector154 = new Sector("Maritime", sector15.getId());
        repository.save(sector154);

        final Sector sector1541 = new Sector("Aluminium and steel workboats", sector154.getId());
        repository.save(sector1541);
        final Sector sector1542 = new Sector("Boat/Yacht building", sector154.getId());
        repository.save(sector1542);
        final Sector sector1543 = new Sector("Ship repair and conversion", sector154.getId());
        repository.save(sector1543);

        final Sector sector155 = new Sector("Metal structures", sector15.getId());
        repository.save(sector155);
        final Sector sector156 = new Sector("Other", sector15.getId());
        repository.save(sector156);
        final Sector sector157 = new Sector("Repair and maintenance service", sector15.getId());
        repository.save(sector157);

        final Sector sector16 = new Sector("Metalworking", sector1.getId());
        repository.save(sector16);

        final Sector sector161 = new Sector("Construction of metal structures", sector16.getId());
        repository.save(sector161);
        final Sector sector162 = new Sector("Houses and buildings", sector16.getId());
        repository.save(sector162);
        final Sector sector163 = new Sector("Metal products", sector16.getId());
        repository.save(sector163);
        final Sector sector164 = new Sector("Metal works", sector16.getId());
        repository.save(sector164);

        final Sector sector1641 = new Sector("CNC-machining", sector164.getId());
        repository.save(sector1641);
        final Sector sector1642 = new Sector("Forgings, Fasteners", sector164.getId());
        repository.save(sector1642);
        final Sector sector1643 = new Sector("Gas, Plasma, Laser cutting", sector164.getId());
        repository.save(sector1643);
        final Sector sector1644 = new Sector("MIG, TIG, Aluminum welding", sector164.getId());
        repository.save(sector1644);

        final Sector sector17 = new Sector("Plastic and Rubber", sector1.getId());
        repository.save(sector17);

        final Sector sector171 = new Sector("Packaging", sector17.getId());
        repository.save(sector171);
        final Sector sector172 = new Sector("Plastic goods", sector17.getId());
        repository.save(sector172);
        final Sector sector173 = new Sector("Plastic processing technology", sector17.getId());
        repository.save(sector173);

        final Sector sector1731 = new Sector("Blowing", sector173.getId());
        repository.save(sector1731);
        final Sector sector1732 = new Sector("Moulding", sector173.getId());
        repository.save(sector1732);
        final Sector sector1733 = new Sector("Plastics welding and processing", sector173.getId());
        repository.save(sector1733);

        final Sector sector174 = new Sector("Plastic profiles", sector17.getId());
        repository.save(sector174);

        final Sector sector18 = new Sector("Printing", sector1.getId());
        repository.save(sector18);

        final Sector sector181 = new Sector("Advertising", sector18.getId());
        repository.save(sector181);
        final Sector sector182 = new Sector("Book/Periodicals printing", sector18.getId());
        repository.save(sector182);
        final Sector sector183 = new Sector("Labelling and packaging printing", sector18.getId());
        repository.save(sector183);

        final Sector sector19 = new Sector("Textile and Clothing", sector1.getId());
        repository.save(sector19);

        final Sector sector191 = new Sector("Clothing", sector19.getId());
        repository.save(sector191);
        final Sector sector192 = new Sector("Textile", sector19.getId());
        repository.save(sector192);

        final Sector sector1A = new Sector("Wood", sector1.getId());
        repository.save(sector1A);

        final Sector sector1A1 = new Sector("Other (Wood)", sector1A.getId());
        repository.save(sector1A1);
        final Sector sector1A2 = new Sector("Wooden building materials", sector1A.getId());
        repository.save(sector1A2);
        final Sector sector1A3 = new Sector("Wooden houses", sector1A.getId());
        repository.save(sector1A3);

        final Sector sector2 = new Sector("Other", 0);
        repository.save(sector2);

        final Sector sector21 = new Sector("Creative industries", sector2.getId());
        repository.save(sector21);
        final Sector sector22 = new Sector("Energy technology", sector2.getId());
        repository.save(sector22);
        final Sector sector23 = new Sector("Environment", sector2.getId());
        repository.save(sector23);

        final Sector sector3 = new Sector("Service", 0);
        repository.save(sector3);

        final Sector sector31 = new Sector("Business services", sector3.getId());
        repository.save(sector31);
        final Sector sector32 = new Sector("Engineering", sector3.getId());
        repository.save(sector32);
        final Sector sector33 = new Sector("Information Technology and Telecommunications", sector3.getId());
        repository.save(sector33);

        final Sector sector331 = new Sector("Data processing, Web portals, E-marketing", sector33.getId());
        repository.save(sector331);
        final Sector sector332 = new Sector("Programming, Consultancy", sector33.getId());
        repository.save(sector332);
        final Sector sector333 = new Sector("Software, Hardware", sector33.getId());
        repository.save(sector333);
        final Sector sector334 = new Sector("Telecommunications", sector33.getId());
        repository.save(sector334);

        final Sector sector34 = new Sector("Tourism", sector3.getId());
        repository.save(sector34);
        final Sector sector35 = new Sector("Translation services", sector3.getId());
        repository.save(sector35);
        final Sector sector36 = new Sector("Transport and Logistics", sector3.getId());
        repository.save(sector36);

        final Sector sector361 = new Sector("Air", sector36.getId());
        repository.save(sector361);
        final Sector sector362 = new Sector("Rail", sector36.getId());
        repository.save(sector362);
        final Sector sector363 = new Sector("Road", sector36.getId());
        repository.save(sector363);
        final Sector sector364 = new Sector("Water", sector36.getId());
        repository.save(sector364);
    }
}
