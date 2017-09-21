package com.irinnovative.onepagesigninsignup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.irinnovative.onepagesigninsignup.activity.PlacesActivity;
import com.irinnovative.onepagesigninsignup.adapter.PlacesAdapter;
import com.irinnovative.onepagesigninsignup.pojo.Place;

import java.util.ArrayList;

public class InstitutionActivity extends AppCompatActivity {
    private ListView listViewHotels;
    private ArrayList<Place> listPlaces = new ArrayList<>();
    private Place currentPlace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_institution);
        populate();

        PlacesAdapter adapter = new PlacesAdapter(this, listPlaces);
        listViewHotels = (ListView) findViewById(R.id.listInstitution);
        listViewHotels.setAdapter(adapter);

        listViewHotels.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                currentPlace = listPlaces.get(position);

                Intent intent = new Intent(InstitutionActivity.this, PlacesActivity.class);
                intent.putExtra("places", currentPlace);
                startActivity(intent);
            }
        });
    }

    public void populate() {

        //SAPSAC

        listPlaces.add(new Place("The South African Professional Society on the Abuse of Children",
                "The South African Professional Society on the Abuse of Children (SAPSAC) is a multi-professional society established in March 1999 to provide professionals who are active in the field of abused children with a forum for structured and systematic exchange of information on the subject of child abuse. It is a non-political and non-governmental organisation registered as an NPO and it provides for membership from the following professions:\n" +
                        "\n" +
                        "Legal Professions (Private and employed within the South African Judicial System)\n" +
                        "Medical Professions (Medical Doctors and Nursing Professionals)\n" +
                        "Social Work Professions\n" +
                        "Policing\n" +
                        "Criminology\n" +
                        "Psychology\n" +
                        "Education\n" +
                        "Media ",
                new int[]{R.drawable.sapsac}, "P.O.Box 1267\n" +
                "Menlyn Central",
                "http://www. .co.za/", "012 991 0718"));

        //Powa

        listPlaces.add(new Place("People Oppressing Women Abuse",
                "POWA is a “feminist, women’s rights organisation that provides both services, and engages in advocacy in order to ensure the realisation of women’s rights and thereby improve women’s quality of life”.\n" +
                        "\n" +
                        "POWA’s uniqueness as an organisation is in providing both services to survivors and engaging in advocacy using a feminist and intersectional analysis. Our work is rooted in the belief that change can only be said to be effective when women’s lives are directly improved through our interventions. We also believe that there is no single route to change, and thus constantly seek new and creative approaches in our programming to achieve the change we seek. ",
                new int[]{R.drawable.powa}, "PO Box 93416, Yeoville 2143\n" +
                "Johannesburg\n"
                ,
                "http://www.powa.co.za", "011 591 6803"));

        //Women and Men Against Child Abuse

        listPlaces.add(new Place("Women & Men Against Child Abuse",
                "Women & Men Against Child Abuse are concerned about a recent incident where a victim of domestic violence was subjected to gross misconduct by the SAPS. \n" +
                        "\n" +
                        "The victim in this case was physically assaulted by her husband, a British national and father of her 5-year old child. When she failed to show up for work, her employer went to check on her and found her battered, upon which she took her to a doctor for examination. ”.\n" +
                        "\n" +
                        "Women & Men Against Child Abuse are concerned about a recent incident where a victim of domestic violence was subjected to gross misconduct by the SAPS. \n" +
                        "\n" +
                        "The victim in this case was physically assaulted by her husband, a British national and father of her 5-year old child. When she failed to show up for work, her employer went to check on her and found her battered, upon which she took her to a doctor for examination. The doctor instructed them to obtain a J88 form from the police station. At Edenvale police station they were wrongly informed by Captain Nthite that a J88 form differs with each police station, and had to collect one at Boksburg Police Station. ",
                new int[]{R.drawable.men_against}, " 6 Benton House,\n" +
                "Bond Street Business Park,\n" +
                "cnr Bond Str and Kent Ave, Randburg\n" +
                "Johannesburg\n"
                ,
                "http://www.wmaca.org", " 011 789 8815"));

        //Life Line

        listPlaces.add(new Place("LIFE LINE",
                "LifeLine South Africa was a service organisation, responding to emotional trauma and individual crises, with a view to providing emotional support. Our range of services focused on supporting and/or developing individuals, enabling them to cope more effectively with the emotional effects of trauma. These services were primarily counselling and personal growth training and development. A diverse range of projects have been initiated and are run by our centres around the region.\n" +
                        "\n" +
                        "As much as these services are still required in communities all around South Africa, we can bring about far more sustainable, effective societal change through a more engaging, proactive approach that focuses on groups of people rather than individuals.\n" +
                        "\n" +
                        "Hence the transformation of the organisation, as reflected in the newly defined vision and mission. Fulfilling this purpose requires an innovative, passionate, diverse group of people with integrity, commitment and a desire to bring about social change.",
                new int[]{R.drawable.blue},
                "28 Melle Street\n" +
                        "Braamfontein\n" +
                        "Johannesburg\n"
                ,
                "http://www.lifeline.org.za", "  082 231 0805"));

        //Tears Foundation

        listPlaces.add(new Place("TEARS Foundation",
                "TEARS Foundation is responsible for the sourcing and collating of a data-base comprised of a fully comprehensive network of services; medical, medico-legal, legal and psychological, currently available throughout South Africa, for the assistance and support of survivors of rape and sexual abuse.. \n" +
                        "\n" +
                        "TEARS Foundation, founded in 2012 is a Registered NPO and PBO that uses technology innovatively in the scourge against domestic violence, sexual assault and child abuse.,",
                new int[]{R.drawable.tear}, " Tears Foundation\n" +
                "TSEBO\n" +
                "85 Protea Road\n" +
                "Kingsley Office Park\n" +
                "Block C\n" +
                "Chislehurston\n" +
                "Sandton"
                ,
                "http://www.tears.co.za", " 010 590 5920"));

        //Child Line

        listPlaces.add(new Place("Childline South Africa ",
                "Childline SA is primarily a counselling service for children up to the age of 18. We chat to children from all over South Africa as well as adults that have concerns about children.\n" +
                        "\n" +
                        "We are available Monday-Friday, 2pm-6pm, except on public holidays.\n" +
                        "\n" +
                        "We know it can sometimes be scary talking to counsellors. Especially for the first time. You might be unsure about what to say or how they'll react. Or wonder who they are?\n" +
                        "\n" +
                        "They're a bunch of different people, some old and some young. They all work for us across South Africa. They have all sorts of hobbies and interests. But most importantly, they all care about young people and give up some their time to volunteer as counsellors. They have been trained on our Crisisline Counselling Course and are constantly updated with issues you may be facing.\n" +
                        "\n" +
                        "You can talk to them about anything, from self-harm and sexting to exam stress and eating problems.,",
                new int[]{R.drawable.childline_south_africa_logo}, " T 24 Stephen Dlamini Road" +
                " Musgrave\n" +
                " Durban\n" +
                "4000\n"
                ,
                "http://www.childlinesa.org.za", " 0800 0555 55"));

        //Child Welfare

        listPlaces.add(new Place("Child Welfare South Africa ",
                "CWSA (Child Welfare South Africa) is an umbrella body representing 151 child welfare affiliates, 30 developing organisations, 25 outreach projects and 206 communities.\n" +
                        "Collectively we reach about 2 million children, their families and caregivers. Consisting of 1200 staff members and 3500 volunteers.\n" +
                        "Our Objectives:\n" +
                        "Protecting the children in our country from all kinds of abuse.\n" +
                        "Making a difference in the lives of children.\n" +
                        "Establishing networks and partnerships to ensure the safeguarding of our children.\n" +
                        "Being a credible, professional body for child protection.\n" +
                        "Providing support and guidance to our Member Organisations.",
                new int[]{R.drawable.child_welfare}, " 247 Monument Road" +
                " Glen Marais\n" +
                " Kempton Park\n" +
                "1619\n"
                ,
                "http://www.childwelfaresa.org.za", " 011 452 4110"));

        //Rape Crisis

        listPlaces.add(new Place(" Rape Crisis Cape Town Trust ",
                "Etablished in 1976, the Rape Crisis Cape Town Trust is the oldest organisation in South Africa supporting the recovery of survivors, seeking justice and making change in communities.\n" +
                        "\n" +
                        "We have a vision of a South Africa in which women are safe in their communities, and where the criminal justice system supports and empowers rape survivors.\n" +
                        "\n" +
                        "Our goal is to promote an end to violence against women – specifically rape. Rape survivors are key to successful convictions and their empowerment is based on safety, respect, support and the ability to make informed choices as they embark on this difficult and challenging journey.\n" +
                        "\n" +
                        "We aim to reduce the trauma experienced by survivors and encourage them to report rape. We support communities in challenging high rape rates and flaws in the criminal justice system.",
                new int[]{R.drawable.rapecrisis}, " 23 Trill Road, Observatory" +
                " Cape Town \n" +
                "  7925\n"
                ,
                "http://www.rapecrisis.org.za", " 021 447 9762"));

        //Jo'burg Child Welfare

        listPlaces.add(new Place(" Jo'burg Child Welfare ",
                "Our vision is of a society where children can grow up strong, safe and happy, where parents and caregivers can create the best possible family setting, so that no child suffers.\n" +
                        "\n" +
                        "Last year, our dedicated team of over 200 staff and volunteers reached over 47,000 children and individuals through protection, adoption, foster care, residential care, education and training work.\n" +
                        "\n" +
                        "Since 1909, Jo’burg Child Welfare has played a pivotal role in child care and protection strategies across the country. Nationally we advise on legislation to protect children, and through advocacy work we ensure children have a voice to influence services which affect them. We support those who have no where else to turn..",
                new int[]{R.drawable.jhb}, " 1st Floor, Edura House" +
                " 41 Fox Street \n" +
                "  Johannesburg\n"
                ,
                "http://www.jhbchildwelfare.co.za", " 011 298 8500"));

        //The South African Depression and Anxiety Group

        listPlaces.add(new Place(" The South African Depression and Anxiety Group ",
                "Mental illness, and the stigma surrounding it, is a critical issue in South Africa. The South African Depression and Anxiety Group (SADAG) is at the forefront of patient advocacy, education and destigmatisation of mental illness in the country. Its expertise lies in assisting patients and callers throughout South Africa with mental health queries.\n" +
                        "\n" +
                        "SADAG is a Non-Profit Organisation, a Registered Section 21 Company, with an 18a tax exemption. It has on its board a powerful team of Patients, Psychiatrists, Psychologists, and General Practitioners. SADAG was established twenty years ago to serve as a support network for the thousands of South Africans who live with mental health problems. Currently, it is estimated that 1 in 5 people will, or do, suffer from a mental illness. SADAG manages a 16-line counselling-and-referral call centre, and is the voice of patient advocacy, working in urban, peri-urban, and the most rural communities across South Africa.",
                new int[]{R.drawable.sadag}, " Catherine St, Johannesburg" +
                " 2000 \n" +
                "  South Africa\n"
                ,
                "http://www.sadag.org", " 021 447 9762"));

        //Jelly Beans

        listPlaces.add(new Place(" The South African Depression and Anxiety Group ",
                "At Jelly Beanz, we believe children should be free. Free to live. To love. To learn. To play and to grow, knowing that they matter. We know that most children and families who’ve experienced trauma and abuse don’t have access to mental health services and the support they need. So we reach out to the most vulnerable and disadvantaged.\n" +
                        "PROJECTS\n" +
                        "AND PROGRAMMES\n" +
                        "We provide individual and group therapy to children who’ve suffered trauma and abuse\n" +
                        "We create therapeutic tools and treatment programmes\n" +
                        "We provide training to professionals who work with child protection and mental health.",
                new int[]{R.drawable.jelly}, "\t641 Edgar , Street" +
                " Garsfontein \n" +
                "  Pretoria\n"
                ,
                "http://www.jellybeanz.org.za", " +012 998 1364"));

        //South African MALE SURVIVORS of Sexual Abuse

        listPlaces.add(new Place(" South African MALE SURVIVORS of Sexual Abuse",
                "A new organization has emerged to provide a support structure for non-offending male survivors of sexual abuse and rape.\n" +
                        "\n" +
                        "South African MALE SURVIVORS of Sexual Abuse  NPC is a non-profit company registered in terms of section 14 of the Companies Act, 2008  in South Africa. registration number  2012/176739/08 and is based in the central business district of Johannesburg, South Africa.\n" +
                        "\n" +
                        "The new acronym  SAMSOSA (South African Male Survivors of Sexual Abuse) will serve as a resource and referral centre, providing information, support and training for victims, affected individuals and organisations in a safe, non-judgmental structure. In addition, we will act as an advocacy group for non-offending male rape and abuse survivors to create awareness and understanding that will change social attitudes and structures.\n" +
                        "\n" +
                        "The rape and sexual abuse of both adult and young men around the world has been so greatly ignored, disrespected and discounted for, that it has created a major misconception in many that such an occurrence does not exist. Many services currently available are solely focused on meeting the needs of female victims who have been abused and sexually assaulted and in this exclusivity silently perpetuate the fallacy that male rape does not exist. The vast majority of male rape and abuse victims will never report their trauma due to a lack of awareness and misunderstandings of male sexual abuse as well as the current lack of support services available, instead they choose to suffer its effects alone and in silence.",
                new int[]{R.drawable.samosa}, "\n  1st Floor, SEWAFRICA House" +
                " 136 Pritchard Street \n" +
                "   Johannesburg, South Africa\n"
                ,
                "http://www.samsosa.org", " 071 280 9918"));

        // Shukumisa

        listPlaces.add(new Place("  Shukumisa",
                "The Shukumisa Campaign was launched in 2008 by members of the National Working Group on Sexual Offences (NWGSO). The NWGSO was originally formed in 2004 to advocate around the proposed Sexual Offences Bill. When the Criminal Law [Sexual Offences and Related Matters] Amendment Act no. 32 of 2007 (Sexual Offences Act) was passed in late 2007, the NWGSO turned its focus to the implementation of the Sexual Offences Act and reformulated itself as the Shukumisa Campaign.\n" +
                        "\n" +
                        "The Shukumisa Campaign aims to stir and shake up public and political will to develop and implement policies and strengthen laws related to sexual offences in South Africa. It periodically carries out monitoring at police stations, health facilities and courts to determine the extent to which government departments and service providers are meeting their commitments to providing services to victims of sexual offences.\n" +
                        "\n" +
                        "The Shukumisa Campaign is made up of 47 organisations from all nine provinces and is governed by a steering committee comprising of 10 organisations. Its coordination is housed at the Rape Crisis Cape Town Trust (RCCTT) and is assisted administratively by RCCTT and the Tshwaranang Legal Advocacy Centre (TLAC) in Johannesburg.",
                new int[]{R.drawable.shukumisa}, "\n   Oliver Tambo Community Centre" +
                "  128 2nd St, Alexandra \n" +
                "   Wynberg\n"
                ,
                "http://shukumisa.org.za", " 011 885 3305"));


    }
}
