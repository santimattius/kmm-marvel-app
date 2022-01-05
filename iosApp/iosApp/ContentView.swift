import SwiftUI
import shared

struct ContentView: View { 
	let greet = Greeting().greeting()
    let columns: [GridItem] =
    Array(repeating: .init(.flexible()),count: 2)
    
    var body: some View {
        NavigationView{
            ScrollView {
                 LazyVGrid(columns: columns,spacing: 20) {
                     ForEach((0...79), id: \.self) {_ in
                         AsyncImage(url: URL(string: "http://i.annihil.us/u/prod/marvel/i/mg/3/20/5232158de5b16.jpg")) { image in
                                image
                                    .resizable()
                                    .aspectRatio(0.67, contentMode: .fit)
                                    .frame(minWidth: 0,
                                           maxWidth: .infinity,
                                           minHeight: 50)
                                    .cornerRadius(4)
                            } placeholder: {
                                ProgressView()
                            }
                         
                     }
                }
            }.navigationTitle("Hello")
        }
    }
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
