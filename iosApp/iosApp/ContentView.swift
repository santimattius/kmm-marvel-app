import SwiftUI
import shared
import Combine

struct ContentView: View { 
	
    private let sdk = MarvelSDK()
    
    var body: some View {
        CharactersView(viewModel:  CharactersViewModel(sdk: sdk ))
    }
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
