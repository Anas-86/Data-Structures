package RegularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String string="I am a string, Yes, I am.";
        System.out.println(string);
        String yourString=string.replaceAll("I","You");
        System.out.println(yourString);

        //the . (dot class) replaes any character.
        System.out.println(string.replaceAll(".","Y"));

        //the caret boundry matcher ^, replaces the first occurance of the specified pattern
        System.out.println(string.replaceAll("^I","uuu"));
        //notice the difference when not using the caret boundry matcher
        System.out.println(string.replaceAll("I","uuu"));

        //matches returns true if the whole regex is identical to the given String.
        System.out.println(string.matches(".*"));

        //the $ matches the part of the end of the string
        System.out.println(string.replaceAll("I am.$","The end"));

        //replace all occurunces of a e and s
        System.out.println(string.replaceAll("[aes]","CocoCoco"));

        string="abcdefghijklmnopkrstuvwxyz3210";
        //replce any occuruence of a,m, or y that is followed by b or z by UU
        System.out.println(string.replaceAll("[amy][bz]","UUSSM"));

        System.out.println("Harry".replaceAll("[hH]arry","Harry"));
        System.out.println("V={3,7,9,8,5,4,3,5}".matches("[v|V]=\\{(\\d)(\\,\\d)*\\}"));

        //when using the caret inside square brackets it actually means everything apart from.
        System.out.println("Anas Al Kala".replaceAll("[^A^a]","m"));

        //note the following expressions result in the same result
        //you should take into consideration that [a-z] is valid, but [z-a] is not valid
        System.out.println(string.replaceAll("[abcdef0123]","Z"));
        System.out.println(string.replaceAll("[a-f0-3]","Z"));


        //note that regex are case sensitive
        //the following two statements are the same, because (?i) turns the sensitivity off
        string="ABCDEFabcdef0123456";
        System.out.println(string.replaceAll("[a-cA-C0-2]","M"));
        System.out.println(string.replaceAll("(?i)[a-c0-2]","M"));

        //replacing all the numbers in string with o, the following statements are the same
        System.out.println(string.replaceAll("[0-9]","o"));
        System.out.println(string.replaceAll("\\d","o"));

        //replacing all non-digits in string with q
        System.out.println(string.replaceAll("\\D","q"));


        //removing all white spaces in a string
        string="Hallo \t\t I am here\ta b_ %&$%&_,,";
        System.out.println(string);
        System.out.println(string.replaceAll("\\s",""));

        // \w matches a-z and A-Z and 0-9 and underscore.
        System.out.println(string.replaceAll("\\w","X"));
        // \W matchers everything apart from what \w matches
        System.out.println(string.replaceAll("\\W","X"));

        //for replacing the starting and ending of each word with some letter use \b
        System.out.println(string);
        System.out.println(string.replaceAll("\\b","Ü"));

        //using quantifiers
        //the quantifier comes after the pattern and it specifies how many times that pattern should occur
        System.out.println("Hallooooossssfffffkk".replaceAll("o{3}","Z"));

        //the + quantifier specifies one or more characters
        System.out.println("Hallooooossssfffffkk".replaceAll("o+","U"));

        //the * quantifier specifies 0 or more characters
        System.out.println("Hallooooossssfffffkk".replaceAll("Hal*o*","Ö"));

        StringBuilder htmlText=new StringBuilder("<h1>My heading</h1>");
        htmlText.append("<h2>sub-heading</h2>");
        htmlText.append("<p>this is a paragraph about someting</p>");
        htmlText.append("<p>this is another paragraph about something else</p>");
        htmlText.append("<h2>Summary</h2>");
        htmlText.append("<p>this is a summary</p>");
        System.out.println();

        //in order to know if the htmlText includes the pattern <h2> use the following
        String h2Pattern="<h2>";       //the pattern here .*content.* which means: search for the content
        Pattern pattern= Pattern.compile(h2Pattern);
        Matcher matcher=pattern.matcher(htmlText);
        System.out.println(matcher.matches());      //mathces() method returns true or false.

        //to know where and how many occurences of the pattern hePattern there are in the htmlText
        //Important note: a macher needs to bre reset if you want to use it again.
        matcher.reset();
        //only now, the matcher is ready to be reused again.
        int count = 0;
        while(matcher.find()){
            count++;
            System.out.println("occurence : "+count+" at index: "+matcher.start()+" ends at index: "+matcher.end());
        }

        String h2GroupPattern="(<h2>.+?</h2>)";
        Pattern groupTextPattern=Pattern.compile(h2GroupPattern);
        Matcher groupMatcher=groupTextPattern.matcher(htmlText);
        System.out.println(groupMatcher.matches());
        groupMatcher.reset();

        while(groupMatcher.find()){
            System.out.println("occurences : "+groupMatcher.group(1));
        }

        System.out.println();

        String h2TextGroup="(<h2>)(.+?)(</h2>)";
        Pattern h2TextPattern=Pattern.compile(h2TextGroup);
        Matcher h2TextMatcher=h2TextPattern.matcher(htmlText);

        while(h2TextMatcher.find()){
            System.out.println("occurence: "+h2TextMatcher.group(2));
        }

        System.out.println();

        String text="tstvtkt";
        String patternInText="t[^v]"; //which means t not followed by v. (t can be followed by any character but v).
        //but the problem of this use "t[^v]" has a problem which is: there must be a character after t which is not
        //v and when this is the case, the ^ will consume this character.
        //so in the result you will have the first and third occurence of t but not the last t.
        //to avoid this problem use the pattern: "t(?!v)". ? here means look ahead of d
        //and if t is followed by v, do not consider this occurence. (here there will be no consuming, and when
        //t occures alone and nothing after it, it will be considered unlike the first case of using "t[^v]"
        Pattern textPattern=Pattern.compile(patternInText);
        Matcher textMatcher=textPattern.matcher(text);
        count=0;
        while(textMatcher.find()){
            System.out.println("occurence: "+ ++count +" starts at: "+textMatcher.start()+" to "+textMatcher.end());
        }

        System.out.println();

        count=0;
        //using "t(?!v)" instead of "t[^v]"
        String patternInTextv2="t(?!v)";
        Pattern patterInTextv2=Pattern.compile(patternInTextv2);
        Matcher matcherInTextv2=patterInTextv2.matcher(text);

        while(matcherInTextv2.find()){
            System.out.println("occurence: "+ ++count + "starts at: "+matcherInTextv2.start()+" to "+matcherInTextv2.end());
        }

        System.out.println();

        //matching phone number in America
        //a phone number in America should be matching the following patter: (800) 756-8831
        // ^([\(]{1}[0-9]{3}[\)]{1}[ ]{1}[0-9]{3}[\-]{1}[0-9]{4})$
        //the $ at the end means: if anything follows then it must not be a match.
        String phone1="(8002) 756-8831";    //should not match
        String phone2="800 756-8831";       //should not match
        String phone3="(800)756-8831";      //should not match
        String phone4="(320) 700-8841";     //should match

        System.out.println(phone1.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
        System.out.println(phone2.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
        System.out.println(phone3.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
        System.out.println(phone4.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));

        System.out.println();


        //matching visa numbers example
        //the visa number always starts with four and consists of 12 digits. after which comes optionals 3-digits number
        //it has the following form:
        //^4[0-9]{12}([0-9]{3})?$
        //ths ? before the end means one or no occurence of the optional 3-digits number. and $ means there must not be
        //anything at the end.
        String visa1="4847592840912";   //should match
        String visa2="4847592840912756"; //should match
        String visa3="5847592840912756";    //should not
        String visa4="484759284091275";     //should not
        String visa5="484759284091";        //should not

        System.out.println(visa1.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println(visa2.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println(visa3.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println(visa4.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println(visa5.matches("^4[0-9]{12}([0-9]{3})?$"));
    }


}
