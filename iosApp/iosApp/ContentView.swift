import SwiftUI
import shared
import Combine

struct ContentView: View { 
	
    @ObservedObject var viewModel: CharactersViewModel
    
    private let greet = Greeting().greeting()
    
    private let columns: [GridItem] =
    Array(repeating: .init(.flexible()),count: 2)
    
    var body: some View {
        NavigationView{
            ScrollView {
                 LazyVGrid(columns: columns,spacing: 10) {
                     
                     ForEach(viewModel.characters, id: \.id) { item in
                         CharacterItemView(
                            character: item
                         )
                         
                     }
                 }.padding()
            }
            .onAppear{
                viewModel.loadCharacters()
            }
            .navigationTitle(greet)
        }
    }
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
        let sdk = MarvelSDK()
		ContentView(viewModel:  CharactersViewModel(sdk: sdk ))
	}
}
