//
//  CharactersView.swift
//  iosApp
//
//  Created by Santiago Mattiauda on 19/1/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import Combine
import shared

struct CharactersView: View {
    
    @ObservedObject var viewModel: CharactersViewModel
    
    private let columns: [GridItem] =
    Array(repeating: .init(.flexible()),count: 2)
    
    var body: some View {
        NavigationView{
             content()
                .onAppear{
                    viewModel.loadCharacters()
                }
                .navigationTitle("KMM Marvel App")
        }
    }
    
    private func content() -> AnyView {
        switch viewModel.state {
            case .loading:
                return AnyView(ProgressView())
            case .result(let characters):
            return AnyView(
                    ScrollView {
                        LazyVGrid(columns: columns,spacing: 10) {
                            ForEach(characters, id: \.id) { item in
                                NavigationLink(
                                   destination: CharacterDetailView(
                                       viewModel: CharacterDetailViewModel(
                                           sdk: MarvelSDK()
                                       ),
                                       character: item
                                   )){
                                   CharacterItemView(
                                      character: item
                                   )
                                }

                            }
                        }.padding()
                    }
                )
            case .error(let description):
                return AnyView(Text(description).multilineTextAlignment(.center))
            }
        }
}

struct CharactersView_Previews: PreviewProvider {
    static var previews: some View {
        let sdk = MarvelSDK()
        CharactersView(viewModel:  CharactersViewModel(sdk: sdk))
    }
}
