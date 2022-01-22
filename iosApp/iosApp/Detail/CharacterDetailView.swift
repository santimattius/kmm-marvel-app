//
//  CharacterDetailView.swift
//  iosApp
//
//  Created by Santiago Mattiauda on 19/1/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import shared

struct CharacterDetailView: View {
    
    @Environment(\.presentationMode) var presentationMode
    @ObservedObject var viewModel: CharacterDetailViewModel
    
    var character:UiCharacter
    
    var body: some View {
        ScrollView{
            content()
        }
        .edgesIgnoringSafeArea(.top)
        .navigationBarBackButtonHidden(true)
        .navigationBarItems(leading:
            Button(action: {
                //Navegar a la pantalla previa
                self.presentationMode.wrappedValue.dismiss()
            }, label: {
                Image(systemName: "arrow.left.circle.fill")
                    .font(.title)
                    .foregroundColor(.white)
            })
        ).onAppear{
            self.viewModel.loadCharacters(character: self.character)
        }
    }
    
    private func content() -> AnyView {
        switch viewModel.state {
            case .loading:
                return AnyView(ProgressView())
            case .result(let character):
            return AnyView(
                    VStack{
                        AsyncImage(
                            url: URL(string: character.thumbnail),
                            transaction: Transaction(animation: .easeIn)) { phase in
                            switch phase {
                            case .empty:
                                ZStack{
                                    Color.gray.opacity(0.1)
                                    ProgressView()
                                }
                            case .success(let image):
                                image
                                    .resizable()
                                    .scaledToFill()

                            case .failure(_):
                                Image(systemName: "exclamationmark.icloud")
                                    .resizable()
                                    .scaledToFit()
                                    .foregroundColor(.gray)

                            @unknown default:
                                Image(systemName: "exclamationmark.icloud")
                                    .resizable()
                                    .scaledToFit()
                                    .foregroundColor(.gray)
                            }
                        }
                        .frame(
                            maxWidth: .infinity,
                            minHeight: 500
                        )
                        
                        Text(character.name)
                            .font(.system(.title, design: .rounded))
                            .fontWeight(.black)
                            .multilineTextAlignment(.center)
                            .frame(width:300)
                            .lineLimit(3)
                        
                        Text(character.description)
                            .font(.system(.subheadline, design: .rounded))
                            .foregroundColor(.gray)
                            .multilineTextAlignment(.center)
                            .frame(width:300)
                            .lineLimit(3)
                        
                        Spacer()
                    }
                )
            case .error(let description):
                return AnyView(Text(description).multilineTextAlignment(.center))
            }
        }
}

struct CharacterDetailView_Previews: PreviewProvider {
    static var previews: some View {
        CharacterDetailView(
            viewModel: CharacterDetailViewModel(sdk: MarvelSDK()),
            character: UiCharacter(
                id: 1,
                name: "Prueba",
                thumbnail: "http://i.annihil.us/u/prod/marvel/i/mg/3/20/5232158de5b16.jpg",
                description: "This is description"
            )
        )
    }
}
