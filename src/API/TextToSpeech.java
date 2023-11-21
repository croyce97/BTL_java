package API;

import Data.Word;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class TextToSpeech {
    public static void Speak(Word word) {
        System.setProperty("freetts.voices","com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory" );
        Voice voice = VoiceManager.getInstance().getVoice("kevin16");
        Voice[] voiceList = VoiceManager.getInstance().getVoices();
        for (int i = 0 ; i < voiceList.length;i++) {
            System.out.println("#voice = " + voiceList[i].getName());
        }
        if (voice!= null) {
            voice.allocate();
            System.out.println("VOIce Rate" + voice.getRate());
            System.out.println("VOIce Pitch" + voice.getPitch());
            System.out.println("VOIce Volume" + voice.getVolume());
            boolean status = voice.speak(word.getWord());
            System.out.println("Status" + status);
            voice.deallocate();
        }

        else {
            System.out.println("Erororor");
        }
    }
}
