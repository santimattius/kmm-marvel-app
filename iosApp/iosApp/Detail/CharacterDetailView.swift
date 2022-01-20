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
    
    var characterId: Int64
    
    var character:UiCharacter
    
    var body: some View {
        ScrollView{
            VStack{
                AsyncImage(
                    url: URL(string: (viewModel.character ?? character).thumbnail),
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

                    @unknown default:
                        Image(systemName: "exclamationmark.icloud")
                    }
                }
                .frame(
                    maxWidth: .infinity,
                    minHeight: 500
                )
                
                Text((viewModel.character ?? character).name)
                    .font(.system(.title, design: .rounded))
                    .fontWeight(.black)
                    .multilineTextAlignment(.center)
                    .frame(width:300)
                    .lineLimit(3)
                
                Text((viewModel.character ?? character).description)
                    .font(.system(.subheadline, design: .rounded))
                    .foregroundColor(.gray)
                    .multilineTextAlignment(.center)
                    .frame(width:300)
                    .lineLimit(3)
                
                Spacer()
            }
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
            self.viewModel.loadCharacters(id: self.characterId)
        }
    }
}

struct CharacterDetailView_Previews: PreviewProvider {
    static var previews: some View {
        CharacterDetailView(
            viewModel: CharacterDetailViewModel(sdk: MarvelSDK()),
            characterId: 1,
            character: UiCharacter(
                id: 1,
                name: "Prueba",
                thumbnail: "http://i.annihil.us/u/prod/marvel/i/mg/3/20/5232158de5b16.jpg",
                description: "This is description"
            )
        )
    }
}
